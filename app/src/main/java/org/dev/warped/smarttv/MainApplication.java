package org.dev.warped.smarttv;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.squareup.otto.Bus;

import java.net.InetAddress;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 20.07.2016.
 */
public class MainApplication extends Application implements SharedPreferences.OnSharedPreferenceChangeListener {

    private final Bus mBus = BusProvider.getBus();
    private ReceiverClient mReceiverClient;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).registerOnSharedPreferenceChangeListener(this);

        SharedPreferencesManager.EReceiverType receiverType = SharedPreferencesManager.getReceiverType(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        InetAddress receiverAddress = SharedPreferencesManager.getReceiverAddress(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        mReceiverClient = new ReceiverClient(mBus, receiverType, receiverAddress);
        BusProvider.getBus().register(mReceiverClient);
    }

    @Override
    public void onTerminate() {
        BusProvider.getBus().unregister(mReceiverClient);

        super.onTerminate();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch (key) {
            case SharedPreferencesManager.PREF_KEY_RECEIVER_TYPE:
                SharedPreferencesManager.EReceiverType receiverType = SharedPreferencesManager.getReceiverType(sharedPreferences);
                mReceiverClient.setType(receiverType);
                break;
            case SharedPreferencesManager.PREF_KEY_RECEIVER_ADDRESS:
                InetAddress receiverAddress = SharedPreferencesManager.getReceiverAddress(sharedPreferences);
                mReceiverClient.setAddress(receiverAddress);
                break;
        }
    }
}
