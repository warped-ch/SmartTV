package org.dev.warped.smarttv;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import org.dev.warped.smarttv.events.BouquetsLoadedEvent;
import org.dev.warped.smarttv.events.EpgNowLoadedEvent;
import org.dev.warped.smarttv.events.LoadBouquetsErrorEvent;
import org.dev.warped.smarttv.events.LoadBouquetsEvent;
import org.dev.warped.smarttv.events.LoadEpgNowErrorEvent;
import org.dev.warped.smarttv.events.LoadEpgNowEvent;
import org.dev.warped.smarttv.events.ZapDoneEvent;
import org.dev.warped.smarttv.events.ZapErrorEvent;
import org.dev.warped.smarttv.events.ZapEvent;
import org.dev.warped.smarttv.model.E2EventList;
import org.dev.warped.smarttv.model.E2ServiceList;
import org.dev.warped.smarttv.model.E2SimpleXmlResult;

import java.net.InetAddress;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 20.07.2016.
 */
class ReceiverClient {
    public enum EReceiverType {
        eUnknown,
        eEnigma2
    }

    private final Bus mBus;
    // TODO handle multiple clients
    private Enigma2Client mEnigma2Client;

    public ReceiverClient(Bus bus, EReceiverType type, InetAddress address) {
        mBus = bus;

        mEnigma2Client = new Enigma2Client(address);
    }

    @Subscribe
    public void onLoadBouquets(LoadBouquetsEvent event) {
        final Call<E2ServiceList> call = mEnigma2Client.getApiService().getServices();
        call.enqueue(new Callback<E2ServiceList>() {
            @Override
            public void onResponse(Call<E2ServiceList> call, Response<E2ServiceList> response) {
                if (null != response.body()) {
                    Timber.d("onLoadBouquets: onResponse: \"%s\".", response.body());
                    mBus.post(new BouquetsLoadedEvent(response.body().getServiceList()));
                } else {
                    Timber.w("onLoadBouquets: onResponse: response body is null.");
                    mBus.post(new LoadBouquetsErrorEvent(new NullPointerException()));
                }
            }
            @Override
            public void onFailure(Call<E2ServiceList> call, Throwable t) {
                Timber.w("onLoadBouquets: onFailure: something went wrong.");
                mBus.post(new LoadBouquetsErrorEvent(t));
            }
        });
    }

    @Subscribe
    public void onLoadEpgNow(LoadEpgNowEvent event) {
        final Call<E2EventList> call = mEnigma2Client.getApiService().getEpgNow(event.getBouquet().getReference());
        call.enqueue(new Callback<E2EventList>() {
            @Override
            public void onResponse(Call<E2EventList> call, Response<E2EventList> response) {
                if (null != response.body()) {
                    Timber.d("onLoadEpgNow: onResponse: \"%s\".", response.body());
                    mBus.post(new EpgNowLoadedEvent(response.body().getEventList()));
                } else {
                    Timber.w("onLoadEpgNow: onResponse: response body is null.");
                    mBus.post(new LoadEpgNowErrorEvent(new NullPointerException()));
                }
            }
            @Override
            public void onFailure(Call<E2EventList> call, Throwable t) {
                Timber.w("onLoadEpgNow: onFailure: something went wrong.");
                mBus.post(new LoadEpgNowErrorEvent(t));
            }
        });
    }

    @Subscribe
    public void onZap(ZapEvent event) {
        final Call<E2SimpleXmlResult> call = mEnigma2Client.getApiService().getZap(event.getChannel().getReference());
        call.enqueue(new Callback<E2SimpleXmlResult>() {
            @Override
            public void onResponse(Call<E2SimpleXmlResult> call, Response<E2SimpleXmlResult> response) {
                if (null != response.body()) {
                    Timber.d("onZap: onResponse: \"%s\".", response.body());
                    mBus.post(new ZapDoneEvent(response.body()));
                } else {
                    Timber.w("onZap: onResponse: response body is null.");
                    mBus.post(new ZapErrorEvent(new NullPointerException()));
                }
            }
            @Override
            public void onFailure(Call<E2SimpleXmlResult> call, Throwable t) {
                Timber.w("onZap: onFailure: something went wrong.");
                mBus.post(new ZapErrorEvent(t));
            }
        });
    }
}
