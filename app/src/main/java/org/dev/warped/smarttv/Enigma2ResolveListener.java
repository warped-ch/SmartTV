package org.dev.warped.smarttv;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;

import org.dev.warped.smarttv.model.E2About;
import org.dev.warped.smarttv.model.E2Abouts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 11.08.2016.
 */
public class Enigma2ResolveListener implements NsdManager.ResolveListener {

    private final DeviceDiscovery mDeviceDiscovery;

    public Enigma2ResolveListener(DeviceDiscovery deviceDiscovery) {
        mDeviceDiscovery = deviceDiscovery;
    }

    @Override
    public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {
        Timber.e("onResolveFailed: serviceInfo=%s, errorCode=%d", serviceInfo, errorCode);
    }

    @Override
    public void onServiceResolved(final NsdServiceInfo serviceInfo) {
        Timber.d("onServiceResolved: %s", serviceInfo);

        Enigma2Client e2Client = new Enigma2Client(serviceInfo.getHost());
        final Call<E2Abouts> call = e2Client.getApiService().getAbouts();
        call.enqueue(new Callback<E2Abouts>() {
            @Override
            public void onResponse(Call<E2Abouts> call, Response<E2Abouts> response) {
                if (null != response.body()) {
                    Timber.d("onServiceResolved: onResponse: \"%s\".", response.body());
                    List<E2About> abouts = response.body().getAboutList();
                    if (!abouts.isEmpty()) {
                        mDeviceDiscovery.addReceiver(ResourceUtil.getReceiverType(abouts.get(0).getModel()), serviceInfo);
                    }
                } else {
                    Timber.w("onServiceResolved: onResponse: response body is null.");
                }
            }
            @Override
            public void onFailure(Call<E2Abouts> call, Throwable t) {
                Timber.w("onServiceResolved: onFailure: something went wrong.");
            }
        });
    }
}
