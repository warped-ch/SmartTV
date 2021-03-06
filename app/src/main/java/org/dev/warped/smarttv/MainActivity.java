package org.dev.warped.smarttv;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.mikepenz.aboutlibraries.LibsBuilder;
import com.squareup.otto.Subscribe;

import org.dev.warped.smarttv.events.ControlVolumeEvent;
import org.dev.warped.smarttv.events.ControlVolumeEventDone;
import org.dev.warped.smarttv.events.ControlVolumeEventError;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity
        implements FragmentManager.OnBackStackChangedListener,
        NavigationView.OnNavigationItemSelectedListener,
        BouquetListFragment.OnBouquetListFragmentInteractionListener,
        ChannelListFragment.OnChannelListFragmentInteractionListener,
        DeviceListFragment.OnDeviceListFragmentInteractionListener,
        EpgEventListFragment.OnEpgEventListFragmentInteractionListener {

    private ActionBar mActionBar;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().addOnBackStackChangedListener(this);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mActionBar = getSupportActionBar();

        DrawerLayout mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerToggle.setToolbarNavigationClickListener(v -> {
            if (!mDrawerToggle.isDrawerIndicatorEnabled()) {
                onBackPressed();
            }
        });
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        if (null == savedInstanceState) {
            createInitialFragment(mNavigationView);
        } else {
            updateDrawerIndicator();
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onBackStackChanged() {
        updateDrawerIndicator();
        updateNavigationView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            menu.findItem(R.id.action_refresh).setVisible(false);
            menu.findItem(R.id.action_close).setVisible(false);
        } catch (NullPointerException e) {
            Timber.e("onPrepareOptionsMenu: menu item is null.");
        }

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        // Handle your other action bar items...
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Timber.d("onKeyDown: %s", event);
                BusProvider.getBus().post(new ControlVolumeEvent(ControlVolumeEvent.EVolumeControlType.eDown));
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                Timber.d("onKeyDown: %s", event);
                BusProvider.getBus().post(new ControlVolumeEvent(ControlVolumeEvent.EVolumeControlType.eUp));
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_bouquets:
                Timber.d("onNavigationItemSelected: item %s selected.", getResources().getString(R.string.bouquets));
                showFragment(new BouquetListFragment());
                break;
            case R.id.nav_devices:
                Timber.d("onNavigationItemSelected: item %s selected.", getResources().getString(R.string.devices));
                showFragment(new DeviceListFragment());
                break;
            case R.id.nav_settings:
                Timber.d("onNavigationItemSelected: item %s selected.", getResources().getString(R.string.settings));
                showFragment(new SettingsFragment());
                break;
            case R.id.nav_about:
                Timber.d("onNavigationItemSelected: item %s selected", getResources().getString(R.string.about));
                getSupportActionBar().setTitle(R.string.about);
                showFragment(new LibsBuilder().withAboutIconShown(true).withAboutVersionShown(true).fragment());
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPause() {
        super.onPause();

        BusProvider.getBus().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        BusProvider.getBus().register(this);
    }

    @Override
    public void onShowBouquet(Bouquet bouquet) {
        Timber.d("onShowBouquet: \"%s\".", bouquet.getName());
        showFragment(ChannelListFragment.newInstance(bouquet));
    }

    @Override
    public void onShowChannel(Channel channel) {
        Timber.d("onShowChannel: \"%s\".", channel.getName());
        showFragment(EpgEventListFragment.newInstance(channel));
    }

    @Subscribe
    public void onControlVolumeEventDone(ControlVolumeEventDone event) {
        Timber.d("onControlVolumeEventDone: current volume = %d", event.getCurrentVolume());
    }

    @Subscribe
    public void onControlVolumeEventError(ControlVolumeEventError event) {
        SnackBarFactory.showSnackBar(this, R.string.snackbar_control_volume_failed);
    }

    public void setActionBarTitle(String title) {
        if (null != mActionBar) {
            mActionBar.setTitle(title);
        } else {
            Timber.e("setActionBarTitle: mActionBar is null.");
        }
    }

    private void createInitialFragment(NavigationView navigationView) {
        // show bouquet list fragment on initial startup
        navigationView.getMenu().findItem(R.id.nav_bouquets).setChecked(true);
        BouquetListFragment bouquetListFragment = new BouquetListFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, bouquetListFragment, bouquetListFragment.getClass().getName());
        transaction.commit();

        if (SharedPreferencesManager.getReceiverAutoDiscovery(PreferenceManager.getDefaultSharedPreferences(this))) {
            Boolean receiverReachable = false;
            String receiverAddress = SharedPreferencesManager.getReceiverAddress(PreferenceManager.getDefaultSharedPreferences(this));
            if (null != receiverAddress && !receiverAddress.isEmpty()) {
                try {
                    receiverReachable = new AsyncTaskIsReachable().execute(receiverAddress).get(100, TimeUnit.MILLISECONDS);
                } catch (ExecutionException e) {
                    Timber.e(e, "onCreate: ExecutionException exception caught.");
                } catch (InterruptedException e) {
                    Timber.e(e, "onCreate: IllegalStateException exception caught.");
                } catch (TimeoutException e) {
                    Timber.e(e, "onCreate: InterruptedException exception caught.");
                }
            }
            if (!receiverReachable) {
                showFragment(new DeviceListFragment());
            }
        } else {
            if (!SharedPreferencesManager.areSettingsDefined(PreferenceManager.getDefaultSharedPreferences(this))) {
                showFragment(new SettingsFragment());
                SnackBarFactory.showSnackBar(this, R.string.snackbar_please_define_settings);
            }
        }
    }

    private void showFragment(Fragment fragment) {
        String fragmentTag = fragment.getClass().getName();
        boolean fragmentPopped = getFragmentManager().popBackStackImmediate(fragmentTag, 0);
        if (!fragmentPopped) {
            // Fragment not in back stack, create it
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (fragment instanceof DeviceListFragment) {
                ft.addToBackStack(fragmentTag);
                ((DeviceListFragment) fragment).show(ft, fragmentTag);
            } else {
                ft.replace(R.id.fragment_container, fragment, fragmentTag);
                ft.addToBackStack(fragmentTag);
                ft.commit();
            }
        }
    }

    private void updateDrawerIndicator() {
        // Note: the order in which views are enabled and disabled is important.
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            if (!(getFragmentManager().getBackStackEntryAt(getFragmentManager().getBackStackEntryCount() - 1).getName().equals(DeviceListFragment.class.getName()))) {
                // Show home as up navigation
                mDrawerToggle.setDrawerIndicatorEnabled(false);
                mActionBar.setDisplayHomeAsUpEnabled(true);
            }
        } else {
            // Show navigation drawer toggle
            mActionBar.setDisplayHomeAsUpEnabled(false);
            mDrawerToggle.setDrawerIndicatorEnabled(true);
        }
    }

    private void updateNavigationView() {
        BouquetListFragment bouquetListFragment = (BouquetListFragment) getFragmentManager().findFragmentByTag(BouquetListFragment.class.getName());
        boolean bouquetsChecked = (null != bouquetListFragment && bouquetListFragment.isVisible());
        mNavigationView.getMenu().findItem(R.id.nav_bouquets).setChecked(bouquetsChecked);
    }
}
