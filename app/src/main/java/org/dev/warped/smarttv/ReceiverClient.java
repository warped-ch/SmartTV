package org.dev.warped.smarttv;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import org.dev.warped.smarttv.events.BouquetsLoadedEvent;
import org.dev.warped.smarttv.events.LoadBouquetsErrorEvent;
import org.dev.warped.smarttv.events.LoadBouquetsEvent;
import org.dev.warped.smarttv.model.E2ServiceList;

import java.net.InetAddress;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 20.07.2016.
 */
public class ReceiverClient {
    private final Bus mBus;
    // TODO handle multiple clients
    private Enigma2Client mEnigma2Client;

    public ReceiverClient(Bus bus, SharedPreferencesManager.EReceiverType type, InetAddress address) {
        mBus = bus;
        mBus.register(this);

        mEnigma2Client = new Enigma2Client(address);
    }

    public void setType(SharedPreferencesManager.EReceiverType type) {
        // TODO: handle receiver types
    }

    public void setAddress(InetAddress address) {
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
}
