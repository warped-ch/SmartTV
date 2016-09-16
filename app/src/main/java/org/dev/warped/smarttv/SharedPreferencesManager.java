package org.dev.warped.smarttv;

import android.content.SharedPreferences;

import java.net.InetAddress;
import java.util.concurrent.ExecutionException;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 22.06.2016.
 */
class SharedPreferencesManager {
    public static final String PREF_KEY_RECEIVER_AUTO_DISCOVERY = "pref_key_receiver_auto_discovery";
    public static final String PREF_KEY_RECEIVER_TYPE = "pref_key_receiver_type";
    public static final String PREF_KEY_RECEIVER_ADDRESS = "pref_key_receiver_address";

    public static boolean areSettingsDefined(SharedPreferences sharedPreferences) {
        return (isReceiverAddressDefined(sharedPreferences) && isReceiverTypeDefined(sharedPreferences));
    }

    public static boolean getReceiverAutoDiscovery(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(PREF_KEY_RECEIVER_AUTO_DISCOVERY, true);
    }

    public static String getReceiverAddress(SharedPreferences sharedPreferences) {
        String address = null;
        if (sharedPreferences.contains(PREF_KEY_RECEIVER_ADDRESS)) {
            address = sharedPreferences.getString(PREF_KEY_RECEIVER_ADDRESS, "");
        } else {
            Timber.e("getReceiverAddress: SharedPreferences do not contain \"%s\".", PREF_KEY_RECEIVER_ADDRESS);
        }
        return address;
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

    public static boolean isReceiverAddressDefined(SharedPreferences sharedPreferences) {
        String receiverAddress = getReceiverAddress(sharedPreferences);
        return (null != receiverAddress && !receiverAddress.isEmpty());
    }

    public static boolean isReceiverTypeDefined(SharedPreferences sharedPreferences) {
        ReceiverClient.EReceiverType receiverType = getReceiverType(sharedPreferences);
        return (null != receiverType && ReceiverClient.EReceiverType.eUnknown != receiverType);
    }

    public static void setReceiverAddress(SharedPreferences sharedPreferences, InetAddress address) {
        String hostAddress = address.getHostAddress();
        if (!getReceiverAddress(sharedPreferences).equals(hostAddress)) {
            Timber.d("setReceiverAddress: hostAddress=%s", hostAddress);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(PREF_KEY_RECEIVER_ADDRESS, hostAddress);
            editor.apply();
        }
    }

    public static void setReceiverType(SharedPreferences sharedPreferences, ReceiverClient.EReceiverType receiverType) {
        if (getReceiverType(sharedPreferences) != receiverType) {
            String receiverTypeValue = ResourceUtil.getReceiverTypeValue(receiverType);
            Timber.d("setReceiverType: receiverTypeValue=%s", receiverTypeValue);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(PREF_KEY_RECEIVER_TYPE, receiverTypeValue);
            editor.apply();
        }
    }
}
