package org.dev.warped.smarttv;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 11.08.2016.
 */
public class Enigma2DiscoveryListener implements NsdManager.DiscoveryListener {

    public static final String SERVICE_TYPE = "_workstation._tcp.";

    private final DeviceDiscovery mDeviceDiscovery;
    private final NsdManager mNsdManager;

    public Enigma2DiscoveryListener(DeviceDiscovery deviceDiscovery, NsdManager nsdManager) {
        mDeviceDiscovery = deviceDiscovery;
        mNsdManager = nsdManager;
    }

    @Override
    public void onDiscoveryStarted(String serviceType) {
        Timber.d("onDiscoveryStarted: %s", serviceType);
    }

    @Override
    public void onServiceFound(NsdServiceInfo serviceInfo) {
        Timber.d("onServiceFound: %s", serviceInfo);
        // TODO: extend for other Enigma2 devices
        if (serviceInfo.getServiceType().equals(SERVICE_TYPE) && serviceInfo.getServiceName().contains("dm800se")) {
            Timber.d("onServiceFound: Enigma2 device found: %s", serviceInfo);
            mNsdManager.resolveService(serviceInfo, new DeviceResolveListener(mDeviceDiscovery));
        }
    }

    @Override
    public void onServiceLost(NsdServiceInfo serviceInfo) {
        Timber.w("onServiceLost: %s", serviceInfo);
        mDeviceDiscovery.removeService(serviceInfo);
    }

    @Override
    public void onDiscoveryStopped(String serviceType) {
        Timber.d("onDiscoveryStopped: %s", serviceType);
    }

    @Override
    public void onStartDiscoveryFailed(String serviceType, int errorCode) {
        Timber.e("onStartDiscoveryFailed: serviceType=%s, errorCode=%d", serviceType, errorCode);
    }

    @Override
    public void onStopDiscoveryFailed(String serviceType, int errorCode) {
        Timber.e("onStopDiscoveryFailed: serviceType=%s, errorCode=%d", serviceType, errorCode);
    }

    public String getServiceType() {
        return SERVICE_TYPE;
    }
}
