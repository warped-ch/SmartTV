package org.dev.warped.smarttv;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;

import java.util.ArrayList;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 11.08.2016.
 */
class DeviceDiscovery {
    private final DeviceDiscoveryCallback mCallback;
    private final NsdManager mNsdManager;
    private Enigma2DiscoveryListener mEnigma2DiscoveryListener;
    private ArrayList<Device> mDevices = new ArrayList<>();

    public DeviceDiscovery(DeviceDiscoveryCallback callback, Context context) {
        mCallback = callback;
        mNsdManager = (NsdManager) context.getSystemService(Context.NSD_SERVICE);
    }

    public void startDiscovery() {
        Timber.d("startDiscovery: ");
        stopDiscovery();  // Cancel any existing discovery request
        initializeDiscoveryListener();
        mNsdManager.discoverServices(
                mEnigma2DiscoveryListener.getServiceType(), NsdManager.PROTOCOL_DNS_SD, mEnigma2DiscoveryListener);
    }

    public void stopDiscovery() {
        Timber.d("stopDiscovery: ");
        if (mEnigma2DiscoveryListener != null) {
            try {
                mNsdManager.stopServiceDiscovery(mEnigma2DiscoveryListener);
            } finally {
                mEnigma2DiscoveryListener = null;
            }
        }
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

    private void initializeDiscoveryListener() {
        mEnigma2DiscoveryListener = new Enigma2DiscoveryListener(this, mNsdManager);
    }
}
