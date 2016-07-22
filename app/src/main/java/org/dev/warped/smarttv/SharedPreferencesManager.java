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

    enum EReceiverType {
        eEnigma2
    }

    public static boolean areSettingsDefined(SharedPreferences sharedPreferences) {
        return ((null != getReceiverType(sharedPreferences)) && (null != getReceiverAddress(sharedPreferences)));
    }

    public static EReceiverType getReceiverType(SharedPreferences sharedPreferences) {
        EReceiverType type = null;
        if (sharedPreferences.contains(PREF_KEY_RECEIVER_TYPE)) {
            String receiverType = sharedPreferences.getString(PREF_KEY_RECEIVER_TYPE, "");
            if (!receiverType.isEmpty()) {
                // TODO, anwi: make this safer, values defined in array.receiver_type_values
                switch (receiverType) {
                    case "Dreambox800HDse":
                        type = EReceiverType.eEnigma2;
                        break;
                    default:
                        Timber.e("getReceiverType: unknown receiver type \"%s\".", receiverType);
                        break;
                }
            } else {
                Timber.e("getReceiverType: receiverType is an empty string.");
            }
        } else {
            Timber.e("getReceiverType: SharedPreferences do not contain \"%s\".", PREF_KEY_RECEIVER_TYPE);
        }
        return type;
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
