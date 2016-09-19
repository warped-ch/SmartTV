package org.dev.warped.smarttv;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.test.espresso.NoMatchingViewException;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Andreas Wiedmer on 19.09.2016.
 */
class IntegrationTestHelper {

    private IntegrationTestHelper() {
    }

    public static void navigateBackHome() {
        navigateBackFromChannelListFragment();
        navigateBackFromDeviceListFragment();
        navigateBackFromEpgEventListFragment();
        navigateBackFromSettingsFragment();
    }

    public static void navigateBackFromChannelListFragment() {
        try {
            onView(withId(R.id.fragmentChannelList))
                    .check(matches(isDisplayed()));
            pressBack();
        } catch (NoMatchingViewException e) {
            // ChannelListFragment was not displayed
        }
    }

    public static void navigateBackFromDeviceListFragment() {
        try {
            onView(withId(R.id.fragmentDeviceList))
                    .check(matches(isDisplayed()));
            pressBack();
        } catch (NoMatchingViewException e) {
            // DeviceListFragment was not displayed
        }
    }

    public static void navigateBackFromEpgEventListFragment() {
        try {
            onView(withId(R.id.fragmentEpgEventList))
                    .check(matches(isDisplayed()));
            pressBack();
        } catch (NoMatchingViewException e) {
            // EpgEventListFragment was not displayed
        }
    }

    public static void navigateBackFromSettingsFragment() {
        try {
            onView(withId(R.id.fragmentSettings))
                    .check(matches(isDisplayed()));
            pressBack();
        } catch (NoMatchingViewException e) {
            // SettingsFragment was not displayed
        }
    }

    public static void clearSharedPreferences() {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(getInstrumentation().getTargetContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public static void setReceiverAutoDiscovery(boolean enabled) {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(getInstrumentation().getTargetContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(SharedPreferencesManager.PREF_KEY_RECEIVER_AUTO_DISCOVERY, enabled);
        editor.apply();
    }
}
