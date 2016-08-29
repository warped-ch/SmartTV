package org.dev.warped.smarttv;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import org.dev.warped.smarttv.events.LoadBouquetsEvent;
import org.dev.warped.smarttv.events.LoadBouquetsEventDone;
import org.dev.warped.smarttv.events.LoadBouquetsEventError;
import org.dev.warped.smarttv.events.LoadEpgEventsEvent;
import org.dev.warped.smarttv.events.LoadEpgEventsEventDone;
import org.dev.warped.smarttv.events.LoadEpgEventsEventError;
import org.dev.warped.smarttv.events.LoadEpgNowEvent;
import org.dev.warped.smarttv.events.LoadEpgNowEventDone;
import org.dev.warped.smarttv.events.LoadEpgNowEventError;
import org.dev.warped.smarttv.events.ZapEvent;
import org.dev.warped.smarttv.events.ZapEventDone;
import org.dev.warped.smarttv.events.ZapEventError;
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
        eDM500HD,
        eDM500HDV2,
        eDM800,
        eDM800SE,
        eDM800SEV2,
        eDM7020HD,
        eDM7020HDV2,
        eDM8000
    }

    private final Bus mBus;
    // TODO handle multiple clients
    private Enigma2Client mEnigma2Client;

    public ReceiverClient(Bus bus, EReceiverType type, InetAddress address) {
        mBus = bus;

        mEnigma2Client = new Enigma2Client(address);
    }

    @Subscribe
    public void onLoadBouquetsEvent(LoadBouquetsEvent event) {
        final Call<E2ServiceList> call = mEnigma2Client.getApiService().getServices();
        call.enqueue(new Callback<E2ServiceList>() {
            @Override
            public void onResponse(Call<E2ServiceList> call, Response<E2ServiceList> response) {
                if (null != response.body()) {
                    Timber.d("onLoadBouquets: onResponse: \"%s\".", response.body());
                    mBus.post(new LoadBouquetsEventDone(response.body().getServiceList()));
                } else {
                    Timber.w("onLoadBouquets: onResponse: response body is null.");
                    mBus.post(new LoadBouquetsEventError(new NullPointerException()));
                }
            }
            @Override
            public void onFailure(Call<E2ServiceList> call, Throwable t) {
                Timber.w("onLoadBouquets: onFailure: something went wrong.");
                mBus.post(new LoadBouquetsEventError(t));
            }
        });
    }

    @Subscribe
    public void onLoadEpgNowEvent(LoadEpgNowEvent event) {
        final Call<E2EventList> call = mEnigma2Client.getApiService().getEpgNow(event.getBouquet().getReference());
        call.enqueue(new Callback<E2EventList>() {
            @Override
            public void onResponse(Call<E2EventList> call, Response<E2EventList> response) {
                if (null != response.body()) {
                    Timber.d("onLoadEpgNow: onResponse: \"%s\".", response.body());
                    mBus.post(new LoadEpgNowEventDone(response.body().getEventList()));
                } else {
                    Timber.w("onLoadEpgNow: onResponse: response body is null.");
                    mBus.post(new LoadEpgNowEventError(new NullPointerException()));
                }
            }
            @Override
            public void onFailure(Call<E2EventList> call, Throwable t) {
                Timber.w("onLoadEpgNow: onFailure: something went wrong.");
                mBus.post(new LoadEpgNowEventError(t));
            }
        });
    }

    @Subscribe
    public void onLoadEpgEventsEvent(LoadEpgEventsEvent event) {
        final Call<E2EventList> call = mEnigma2Client.getApiService().getEpgService(event.getChannel().getReference());
        call.enqueue(new Callback<E2EventList>() {
            @Override
            public void onResponse(Call<E2EventList> call, Response<E2EventList> response) {
                if (null != response.body()) {
                    Timber.d("onLoadEpgEvents: onResponse: \"%s\".", response.body());
                    mBus.post(new LoadEpgEventsEventDone(response.body().getEventList()));
                } else {
                    Timber.w("onLoadEpgEvents: onResponse: response body is null.");
                    mBus.post(new LoadEpgEventsEventError(new NullPointerException()));
                }
            }
            @Override
            public void onFailure(Call<E2EventList> call, Throwable t) {
                Timber.w("onLoadEpgEvents: onFailure: something went wrong.");
                mBus.post(new LoadEpgEventsEventError(t));
            }
        });
    }

    @Subscribe
    public void onZapEvent(ZapEvent event) {
        final Call<E2SimpleXmlResult> call = mEnigma2Client.getApiService().getZap(event.getChannel().getReference());
        call.enqueue(new Callback<E2SimpleXmlResult>() {
            @Override
            public void onResponse(Call<E2SimpleXmlResult> call, Response<E2SimpleXmlResult> response) {
                if (null != response.body()) {
                    Timber.d("onZap: onResponse: \"%s\".", response.body());
                    mBus.post(new ZapEventDone(response.body()));
                } else {
                    Timber.w("onZap: onResponse: response body is null.");
                    mBus.post(new ZapEventError(new NullPointerException()));
                }
            }
            @Override
            public void onFailure(Call<E2SimpleXmlResult> call, Throwable t) {
                Timber.w("onZap: onFailure: something went wrong.");
                mBus.post(new ZapEventError(t));
            }
        });
    }
}
