package org.dev.warped.smarttv;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatDelegate;

import com.squareup.otto.Bus;

import java.net.InetAddress;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 20.07.2016.
 */
public class MainApplication extends Application implements SharedPreferences.OnSharedPreferenceChangeListener {

    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }

    private final Bus mBus = BusProvider.getBus();
    private ReceiverClient mReceiverClient;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        // Ensures that the application is properly initialized with default settings
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).registerOnSharedPreferenceChangeListener(this);

        createReceiverClient();
    }

    @Override
    public void onTerminate() {
        if (null != mReceiverClient) {
            BusProvider.getBus().unregister(mReceiverClient);
        }

        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).unregisterOnSharedPreferenceChangeListener(this);

        super.onTerminate();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch (key) {
            case SharedPreferencesManager.PREF_KEY_RECEIVER_TYPE:
            case SharedPreferencesManager.PREF_KEY_RECEIVER_ADDRESS:
                createReceiverClient();
                break;
        }
    }

    private void createReceiverClient() {
        Timber.d("createReceiverClient: called");
        if (null != mReceiverClient) {
            BusProvider.getBus().unregister(mReceiverClient);
            mReceiverClient = null;
        }
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        ReceiverClient.EReceiverType receiverType = SharedPreferencesManager.getReceiverType(sharedPreferences);
        String receiverAddress = SharedPreferencesManager.getReceiverAddress(sharedPreferences);
        if (null != receiverType && null != receiverAddress && !receiverAddress.isEmpty()) {
            Timber.d("createReceiverClient: receiverType=%s, receiverAddress=%s", receiverType, receiverAddress);
            mReceiverClient = new ReceiverClient(mBus, receiverType, receiverAddress);
            BusProvider.getBus().register(mReceiverClient);
        }
    }
}
