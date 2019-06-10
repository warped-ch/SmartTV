package org.dev.warped.smarttv;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import android.widget.Switch;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.PreferenceMatchers.withKey;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class SettingsFragmentTest {

    @BeforeClass
    public static void setUpClass() {
        IntegrationTestHelper.clearSharedPreferences();
        IntegrationTestHelper.disableAutoDiscovery();
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @After
    public void tearDown() {
        IntegrationTestHelper.clearSharedPreferences();
        IntegrationTestHelper.disableAutoDiscovery();
    }

    @Test
    public void ReceiverAutoDiscoveryOn() {
        onData(allOf(is(instanceOf(Preference.class)), withKey(SharedPreferencesManager.PREF_KEY_RECEIVER_AUTO_DISCOVERY)))
                .onChildView(withClassName(is(Switch.class.getName())))
                .perform(click())
                .check(matches(isChecked()));
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getInstrumentation().getTargetContext());
        assertThat(preferences.getBoolean(SharedPreferencesManager.PREF_KEY_RECEIVER_AUTO_DISCOVERY, false), is(true));

        onData(allOf(is(instanceOf(Preference.class)), withKey(SharedPreferencesManager.PREF_KEY_RECEIVER_ADDRESS)))
                .check(matches(not(isEnabled())));
        onData(allOf(is(instanceOf(Preference.class)), withKey(SharedPreferencesManager.PREF_KEY_RECEIVER_TYPE)))
                .check(matches(not(isEnabled())));
    }

    @Test
    public void ReceiverAutoDiscoveryOff() {
        onData(allOf(is(instanceOf(Preference.class)), withKey(SharedPreferencesManager.PREF_KEY_RECEIVER_AUTO_DISCOVERY)))
                .onChildView(withClassName(is(Switch.class.getName())))
                .check(matches(isNotChecked()));
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getInstrumentation().getTargetContext());
        assertThat(preferences.getBoolean(SharedPreferencesManager.PREF_KEY_RECEIVER_AUTO_DISCOVERY, true), is(false));

        onData(allOf(is(instanceOf(Preference.class)), withKey(SharedPreferencesManager.PREF_KEY_RECEIVER_ADDRESS)))
                .check(matches(isEnabled()));
        onData(allOf(is(instanceOf(Preference.class)), withKey(SharedPreferencesManager.PREF_KEY_RECEIVER_TYPE)))
                .check(matches(isEnabled()));
    }
}
