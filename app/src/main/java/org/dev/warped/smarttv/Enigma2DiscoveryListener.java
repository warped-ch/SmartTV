package org.dev.warped.smarttv;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;

import timber.log.Timber;

class Enigma2DiscoveryListener implements NsdManager.DiscoveryListener {

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

        if (isSupportedDevice(serviceInfo)) {
            Timber.d("onServiceFound: Enigma2 device found: %s", serviceInfo);
            mNsdManager.resolveService(serviceInfo, new Enigma2ResolveListener(mDeviceDiscovery));
        }
    }

    @Override
    public void onServiceLost(NsdServiceInfo serviceInfo) {
        Timber.w("onServiceLost: %s", serviceInfo);
        mDeviceDiscovery.removeDevice(serviceInfo);
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
        return "_workstation._tcp";
    }

    private boolean isSupportedDevice(NsdServiceInfo serviceInfo) {
        // MAC address Organizationally Unique Identifier
        final String DreamMultimediaOUI = "00:09:34";

        if (serviceInfo.getServiceType().contains(getServiceType()) && serviceInfo.getServiceName().contains(DreamMultimediaOUI)) {
            Timber.d("isSupportedDevice: device supported: %s", serviceInfo);
            return true;
        } else {
            Timber.d("isSupportedDevice: device not supported: %s", serviceInfo);
            return false;
        }
    }
}
