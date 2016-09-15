package org.dev.warped.smarttv;

import android.net.nsd.NsdServiceInfo;

import org.dev.warped.smarttv.model.E2About;

import java.net.InetAddress;

/**
 * Created by Andreas Wiedmer on 15.09.2016.
 */
public class Enigma2Receiver {

    private final ReceiverClient.EReceiverType mReceiverType;
    private final NsdServiceInfo mServiceInfo;
    private final E2About mE2About;

    public Enigma2Receiver(NsdServiceInfo serviceInfo, E2About e2About) {
        mReceiverType = ResourceUtil.getReceiverType(e2About.getModel());
        mServiceInfo = serviceInfo;
        mE2About = e2About;
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
