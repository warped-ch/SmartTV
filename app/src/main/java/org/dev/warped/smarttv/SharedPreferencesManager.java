package org.dev.warped.smarttv;

import android.content.SharedPreferences;

import java.net.InetAddress;
import java.util.concurrent.ExecutionException;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 22.06.2016.
 */
public class SharedPreferencesManager {

    public static final String PREF_KEY_RECEIVER_TYPE = "pref_key_receiver_type";
    public static final String PREF_KEY_RECEIVER_ADDRESS = "pref_key_receiver_address";

    public static boolean areSettingsDefined(SharedPreferences sharedPreferences) {
        return ((null != getReceiverType(sharedPreferences)) && (null != getReceiverAddress(sharedPreferences)));
    }

    public static ReceiverClient.EReceiverType getReceiverType(SharedPreferences sharedPreferences) {
        ReceiverClient.EReceiverType receiverType = null;
        if (sharedPreferences.contains(PREF_KEY_RECEIVER_TYPE)) {
            String receiverTypeValue = sharedPreferences.getString(PREF_KEY_RECEIVER_TYPE, "");
            receiverType = ResourceUtil.getReceiverType(receiverTypeValue);
            if (ReceiverClient.EReceiverType.eUnknown == receiverType) {
                Timber.w("getReceiverType: receiverType is %s.", ReceiverClient.EReceiverType.eUnknown.toString());
            }
        } else {
            Timber.e("getReceiverType: SharedPreferences do not contain \"%s\".", PREF_KEY_RECEIVER_TYPE);
        }
        return receiverType;
    }

    public static InetAddress getReceiverAddress(SharedPreferences sharedPreferences) {
        InetAddress address = null;
        if (sharedPreferences.contains(PREF_KEY_RECEIVER_ADDRESS)) {
            String prefAddress = sharedPreferences.getString(PREF_KEY_RECEIVER_ADDRESS, "");
            if (!prefAddress.isEmpty()) {
                try {
                    address = new InetAddressTask().execute(prefAddress).get();
                } catch (ExecutionException e) {
                    Timber.e(e, "getReceiverAddress: ExecutionException exception caught.");
                } catch (InterruptedException e) {
                    Timber.e(e, "getReceiverAddress: IllegalStateException exception caught.");
                }
            }
        } else {
            Timber.e("getReceiverType: SharedPreferences do not contain \"%s\".", PREF_KEY_RECEIVER_ADDRESS);
        }
        return address;
    }
}
