package org.dev.warped.smarttv;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 11.08.2016.
 */
public class DeviceResolveListener implements NsdManager.ResolveListener {

    private final DeviceDiscovery mDeviceDiscovery;

    public DeviceResolveListener(DeviceDiscovery deviceDiscovery) {
        mDeviceDiscovery = deviceDiscovery;
    }

    @Override
    public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {
        Timber.e("onResolveFailed: serviceInfo=%s, errorCode=%d", serviceInfo, errorCode);
    }

    @Override
    public void onServiceResolved(NsdServiceInfo serviceInfo) {
        Timber.d("onServiceResolved: %s", serviceInfo);
        mDeviceDiscovery.addService(serviceInfo);
    }
}
