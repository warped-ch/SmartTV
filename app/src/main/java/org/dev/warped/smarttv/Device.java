package org.dev.warped.smarttv;

import android.net.nsd.NsdServiceInfo;

import java.net.InetAddress;

class Device {

    private final ReceiverClient.EReceiverType mReceiverType;
    private final NsdServiceInfo mServiceInfo;

    public Device(ReceiverClient.EReceiverType receiverType, NsdServiceInfo serviceInfo) {
        mReceiverType = receiverType;
        mServiceInfo = serviceInfo;
    }

    public String getName() {
        return mServiceInfo.getHost().getHostName();
    }

    public ReceiverClient.EReceiverType getReceiverType() {
        return mReceiverType;
    }

    public NsdServiceInfo getServiceInfo() {
        return mServiceInfo;
    }

    public InetAddress getAddress() {
        return mServiceInfo.getHost();
    }
}
