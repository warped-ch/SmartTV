package org.dev.warped.smarttv;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;

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
    private ArrayList<Enigma2Receiver> mReceivers = new ArrayList<>();

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
        mReceivers.clear();
    }

    public void addReceiver(Enigma2Receiver receiver) {
        if (!mReceivers.contains(receiver)) {
            mReceivers.add(receiver);
            mCallback.onReceiverDiscovered(receiver);
        }
    }

    public void removeReceiver(final NsdServiceInfo serviceInfo) {
        for (Enigma2Receiver r : mReceivers) {
            if (r.getServiceInfo() == serviceInfo) {
                mReceivers.remove(r);
            }
        }
    }

    public ArrayList<Enigma2Receiver> getReceivers() {
        return mReceivers;
    }
}
