package org.dev.warped.smarttv;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Switch;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.contrib.NavigationViewActions.navigateTo;
import static android.support.test.espresso.matcher.PreferenceMatchers.withKey;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.assertThat;

/**
 * Created by Andreas Wiedmer on 19.09.2016.
 */
@RunWith(AndroidJUnit4.class)
public class SettingsFragmentTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setUp() {
        clearSharedPreferences();
        navigateToSettingsFragment();
    }

    @After
    public void tearDown() {
        clearSharedPreferences();
    }

    @Test
    public void SetReceiverAutoDiscoveryOn() {
        // Receiver auto discovery is enabled in default shared preferences, so leave it enabled for this test
        onData(allOf(is(instanceOf(Preference.class)), withKey(SharedPreferencesManager.PREF_KEY_RECEIVER_AUTO_DISCOVERY)))
                .onChildView(withClassName(is(Switch.class.getName())))
                .check(matches(isChecked()));
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getInstrumentation().getTargetContext());
        assertThat(preferences.getBoolean(SharedPreferencesManager.PREF_KEY_RECEIVER_AUTO_DISCOVERY, false), is(true));

        onData(allOf(is(instanceOf(Preference.class)), withKey(SharedPreferencesManager.PREF_KEY_RECEIVER_ADDRESS)))
                .check(matches(not(isEnabled())));
        onData(allOf(is(instanceOf(Preference.class)), withKey(SharedPreferencesManager.PREF_KEY_RECEIVER_TYPE)))
                .check(matches(not(isEnabled())));
    }

    @Test
    public void SetReceiverAutoDiscoveryOff() {
        // Receiver auto discovery is enabled in default shared preferences, so disable it for this test
        onData(allOf(is(instanceOf(Preference.class)), withKey(SharedPreferencesManager.PREF_KEY_RECEIVER_AUTO_DISCOVERY)))
                .onChildView(withClassName(is(Switch.class.getName())))
                .perform(click())
                .check(matches(isNotChecked()));
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getInstrumentation().getTargetContext());
        assertThat(preferences.getBoolean(SharedPreferencesManager.PREF_KEY_RECEIVER_AUTO_DISCOVERY, true), is(false));

        onData(allOf(is(instanceOf(Preference.class)), withKey(SharedPreferencesManager.PREF_KEY_RECEIVER_ADDRESS)))
                .check(matches(isEnabled()));
        onData(allOf(is(instanceOf(Preference.class)), withKey(SharedPreferencesManager.PREF_KEY_RECEIVER_TYPE)))
                .check(matches(isEnabled()));
    }

    private void clearSharedPreferences(){
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(getInstrumentation().getTargetContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    private void navigateToSettingsFragment() {
        pressBack(); // close the open DeviceListFragment, receiver auto discovery is on by default
        onView(withId(R.id.drawer_layout))
                .perform(open());
        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.nav_settings));
    }
}
