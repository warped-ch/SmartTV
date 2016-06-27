package org.dev.warped.smarttv;

import android.content.Context;

import java.net.InetAddress;

/**
 * Created by Andreas Wiedmer on 22.06.2016.
 */
public class ReceiverFactory {
    static IReceiver newInstance(Context context, IReceiver.EReceiverType type, InetAddress address) {
        IReceiver receiver = null;
        // TODO, anwi: allow type to be null?
        if (null != type) {
            switch (type) {
                case eEnigma2:
                    receiver = new Enigma2Receiver(context, address);
                    break;
            }
        }
        return receiver;
    }
}
