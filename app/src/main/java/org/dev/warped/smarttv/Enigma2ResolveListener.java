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
public class Enigma2ResolveListener implements NsdManager.ResolveListener, AsyncTaskGetHostName.AsyncResponseDelegateHostName {

    private final DeviceDiscovery mDeviceDiscovery;
    private NsdServiceInfo mServiceInfo = null;
    private E2About mE2About = null;

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

        mServiceInfo = serviceInfo;

        Enigma2Client e2Client = new Enigma2Client(serviceInfo.getHost());
        final Call<E2Abouts> call = e2Client.getApiService().getAbouts();
        call.enqueue(new Callback<E2Abouts>() {
            @Override
            public void onResponse(Call<E2Abouts> call, Response<E2Abouts> response) {
                if (null != response.body()) {
                    Timber.d("onServiceResolved: onResponse: \"%s\".", response.body());
                    List<E2About> abouts = response.body().getAboutList();
                    if (!abouts.isEmpty()) {
                        mE2About = abouts.get(0);

                        // Resolve the host name before propagating new device to avoid NetworkOnMainThreadException if anyone gets the host name later on.
                        AsyncTaskGetHostName task = new AsyncTaskGetHostName(Enigma2ResolveListener.this);
                        task.execute(serviceInfo.getHost());
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

    @Override
    public void onPostExecuteGetHostName(String hostName) {
        // Host name resolved, no NetworkOnMainThreadException should occur for any InetAddress calls on this device.
        mDeviceDiscovery.addDevice(new Device(ResourceUtil.getReceiverType(mE2About.getModel()), mServiceInfo));
    }
}
