package org.dev.warped.smarttv;

import java.net.InetAddress;

/**
 * Created by Andreas Wiedmer on 29.08.2016.
 */
public interface DeviceDiscoveryCallback {
    void onReceiverDiscovered(ReceiverClient.EReceiverType receiverType, InetAddress address);
}
