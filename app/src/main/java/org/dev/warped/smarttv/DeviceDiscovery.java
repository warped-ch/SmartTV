package org.dev.warped.smarttv;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 11.08.2016.
 */
public class DeviceDiscovery {
    private  final DeviceDiscoveryCallback mCallback;
    private final NsdManager mNsdManager;
    private Enigma2DiscoveryListener mEnigma2DiscoveryListener;
    private List<NsdServiceInfo> mServices = new ArrayList<>();

    public DeviceDiscovery(DeviceDiscoveryCallback callback, Context context) {
        mCallback = callback;
        mNsdManager = (NsdManager) context.getSystemService(Context.NSD_SERVICE);
    }

    public void initializeDiscoveryListener() {
        mEnigma2DiscoveryListener = new Enigma2DiscoveryListener(this, mNsdManager);
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
            }
            mEnigma2DiscoveryListener = null;
        }
        mServices.clear();
    }

    public void addReceiver(ReceiverClient.EReceiverType receiverType, NsdServiceInfo serviceInfo) {
        if (!mServices.contains(serviceInfo)) {
            mServices.add(serviceInfo);
            mCallback.onReceiverDiscovered(receiverType, serviceInfo.getHost());
        }
    }

    public void removeService(NsdServiceInfo serviceInfo) {
        mServices.remove(serviceInfo);
    }

    public List<InetAddress> getDevices() {
        List<InetAddress> devices = new ArrayList<>();
        for (NsdServiceInfo s : mServices) {
            devices.add(s.getHost());
        }
        return devices;
    }
}
