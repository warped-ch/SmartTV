package org.dev.warped.smarttv;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.Gravity;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.close;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.contrib.NavigationViewActions.navigateTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;

/**
 * Created by Andreas Wiedmer on 19.09.2016.
 */
@RunWith(AndroidJUnit4.class)
public class NavigationDrawerTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setUp() {
        IntegrationTestHelper.clearSharedPreferences();
        IntegrationTestHelper.navigateBackHome();
    }

    @Test
    public void openNavigationDrawer() {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed()))
                .perform(open())
                .check(matches(isOpen(Gravity.LEFT)));
    }

    @Test
    public void closeNavigationDrawer() {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed()))
                .perform(open())
                .check(matches(isOpen(Gravity.LEFT)))
                .perform(close())
                .check(matches(isClosed()));
    }

    @Test
    public void showBouquets() {
        onView(withId(R.id.drawer_layout))
                .perform(open());
        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.nav_bouquets));
        onView(withId(R.id.fragmentBouquetList))
                .check(matches(isDisplayed()));
        onView(withId(R.id.toolbar))
                .check(matches(isDisplayed()));
        onView(allOf(instanceOf(TextView.class), withParent(withId(R.id.toolbar))))
                .check(matches(withText(R.string.bouquets)));
    }

    @Test
    public void showDevices() {
        onView(withId(R.id.drawer_layout))
                .perform(open());
        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.nav_devices));
        onView(withId(R.id.fragmentDeviceList))
                .check(matches(isDisplayed()));
        onView(withId(R.id.toolbar))
                .check(matches(isDisplayed()));
        onView(allOf(instanceOf(TextView.class), withParent(withId(R.id.toolbar))))
                .check(matches(withText(R.string.devices)));
    }

    @Test
    public void showSettings() {
        onView(withId(R.id.drawer_layout))
                .perform(open());
        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.nav_settings));
        onView(withId(R.id.fragmentSettings))
                .check(matches(isDisplayed()));
        onView(withId(R.id.toolbar))
                .check(matches(isDisplayed()));
        onView(allOf(instanceOf(TextView.class), withParent(withId(R.id.toolbar))))
                .check(matches(withText(R.string.settings)));
    }
}
