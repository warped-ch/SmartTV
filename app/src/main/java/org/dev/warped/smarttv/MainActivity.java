package org.dev.warped.smarttv;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().addOnBackStackChangedListener(this);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (null == savedInstanceState) {
            createInitialFragment(navigationView);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onBackStackChanged() {
        updateNavigationView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            menu.findItem(R.id.action_refresh).setVisible(false);
        } catch (NullPointerException e) {
            Timber.e("onPrepareOptionsMenu: menu item action_refresh is null.");
        }

        return super.onPrepareOptionsMenu(menu);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        switch(item.getItemId()) {
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
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
        try {
            getSupportActionBar().setTitle(title);
        } catch (NullPointerException e) {
            Timber.e("setActionBarTitle: getSupportActionBar returned null.");
        }
    }

    private void createInitialFragment(NavigationView navigationView) {
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

            if (receiverReachable) {
                // show bouquet list fragment on initial startup in case receiver is reachable
                navigationView.getMenu().findItem(R.id.nav_bouquets).setChecked(true);
                BouquetListFragment fragment = new BouquetListFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment, fragment.getClass().getName());
                transaction.commit();
            } else {
                // show device list fragment on initial startup in case receiver is not reachable
                DeviceListFragment fragment = new DeviceListFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                fragment.show(transaction, fragment.getClass().getName());
            }
        } else {
            // show bouquet list fragment on initial startup
            navigationView.getMenu().findItem(R.id.nav_bouquets).setChecked(true);
            BouquetListFragment fragment = new BouquetListFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment, fragment.getClass().getName());
            transaction.commit();

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

    private void updateNavigationView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (null != navigationView) {
            BouquetListFragment bouquetListFragment = (BouquetListFragment) getFragmentManager().findFragmentByTag(BouquetListFragment.class.getName());
            if (null != bouquetListFragment && bouquetListFragment.isVisible()) {
                navigationView.getMenu().findItem(R.id.nav_bouquets).setChecked(true);
            }
            SettingsFragment settingsFragment = (SettingsFragment) getFragmentManager().findFragmentByTag(SettingsFragment.class.getName());
            if (null != settingsFragment && settingsFragment.isVisible()) {
                navigationView.getMenu().findItem(R.id.nav_settings).setChecked(true);
            }
        }
    }
}
