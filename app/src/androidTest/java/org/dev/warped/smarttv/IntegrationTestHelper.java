package org.dev.warped.smarttv;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static org.dev.warped.smarttv.SharedPreferencesManager.PREF_KEY_RECEIVER_AUTO_DISCOVERY;

class IntegrationTestHelper {

    private IntegrationTestHelper() {
    }

    static void clearSharedPreferences() {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(getInstrumentation().getTargetContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    static void disableAutoDiscovery() {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(getInstrumentation().getTargetContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(PREF_KEY_RECEIVER_AUTO_DISCOVERY, false);
        editor.apply();
    }
}
