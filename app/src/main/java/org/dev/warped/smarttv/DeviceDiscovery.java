package org.dev.warped.smarttv;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.net.wifi.WifiManager;

import java.util.ArrayList;

import timber.log.Timber;

class DeviceDiscovery {
    private final DeviceDiscoveryCallback mCallback;
    /** MulticastLock to get permission to receive Wifi Multicast packets for Network Service Discovery. */
    private final WifiManager.MulticastLock mMulticastLock;
    private final NsdManager mNsdManager;
    private final Enigma2DiscoveryListener mEnigma2DiscoveryListener;
    private final ArrayList<Device> mDevices = new ArrayList<>();

    public DeviceDiscovery(DeviceDiscoveryCallback callback, Context context) {
        mCallback = callback;

        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        mMulticastLock = wifiManager.createMulticastLock("DeviceDiscovery::startDiscovery");
        mMulticastLock.setReferenceCounted(true);

        mNsdManager = (NsdManager) context.getSystemService(Context.NSD_SERVICE);
        mEnigma2DiscoveryListener = new Enigma2DiscoveryListener(this, mNsdManager);
    }

    public void startDiscovery() {
        Timber.d("startDiscovery: ");
        mMulticastLock.acquire();
        mNsdManager.discoverServices(
                mEnigma2DiscoveryListener.getServiceType(), NsdManager.PROTOCOL_DNS_SD, mEnigma2DiscoveryListener);
    }

    public void stopDiscovery() {
        Timber.d("stopDiscovery: ");
        mNsdManager.stopServiceDiscovery(mEnigma2DiscoveryListener);
        mMulticastLock.release();

        mDevices.clear();
    }

    public void addDevice(Device device) {
        if (!mDevices.contains(device)) {
            mDevices.add(device);
            mCallback.onDeviceDiscovered(device);
        }
    }

    public void removeDevice(final NsdServiceInfo serviceInfo) {
        for (Device d : mDevices) {
            if (d.getServiceInfo() == serviceInfo) {
                mDevices.remove(d);
            }
        }
    }

    public ArrayList<Device> getDevices() {
        return mDevices;
    }
}
