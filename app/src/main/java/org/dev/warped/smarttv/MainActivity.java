package org.dev.warped.smarttv;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.squareup.otto.Subscribe;

import org.dev.warped.smarttv.events.ControlVolumeEvent;
import org.dev.warped.smarttv.events.ControlVolumeEventDone;
import org.dev.warped.smarttv.events.ControlVolumeEventError;

import java.util.ArrayList;

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
            // show device list fragment on initial startup
            DeviceListFragment fragment = new DeviceListFragment();
            fragment.show(getFragmentManager(), fragment.getClass().getName());

//            if (SharedPreferencesManager.getReceiverAutoDiscovery(PreferenceManager.getDefaultSharedPreferences(this))) {
//                // show device list fragment on initial startup
//                DeviceListFragment fragment = new DeviceListFragment();
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container, fragment, fragment.getClass().getName());
//                transaction.commit();
//            } else {
//                // show bouquet list fragment on initial startup
//                navigationView.getMenu().findItem(R.id.nav_bouquets).setChecked(true);
//                BouquetListFragment fragment = new BouquetListFragment();
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container, fragment, fragment.getClass().getName());
//                transaction.commit();
//
//                if (!SharedPreferencesManager.areSettingsDefined(PreferenceManager.getDefaultSharedPreferences(this))) {
//                    replaceFragment(new SettingsFragment());
//                    SnackBarFactory.showSnackBar(this, R.string.snackbar_please_define_settings);
//                }
//            }
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

        MenuItem item = menu.findItem(R.id.action_devices);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        spinner.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Timber.d("onTouch: device spinner touched.");
                    DeviceListFragment fragment = new DeviceListFragment();
                    fragment.show(getFragmentManager(), fragment.getClass().getName());
                }
                return true;
            }
        });
        ArrayList<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("no device");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);

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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_bouquets) {
            Timber.d("onNavigationItemSelected: item %s selected.", getResources().getString(R.string.bouquets));
            replaceFragment(new BouquetListFragment());
        } else if (id == R.id.nav_settings) {
            Timber.d("onNavigationItemSelected: item %s selected.", getResources().getString(R.string.settings));
            replaceFragment(new SettingsFragment());
        } else {
            Timber.w("onNavigationItemSelected: invalid item %d selected.", id);
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
        replaceFragment(ChannelListFragment.newInstance(bouquet));
    }

    @Override
    public void onShowChannel(Channel channel) {
        Timber.d("onShowChannel: \"%s\".", channel.getName());
        replaceFragment(EpgEventListFragment.newInstance(channel));
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

    private void replaceFragment(Fragment fragment) {
        String fragmentTag = fragment.getClass().getName();
        boolean fragmentPopped = getFragmentManager().popBackStackImmediate(fragmentTag, 0);
        if (!fragmentPopped) {
            // Fragment not in back stack, create it
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment, fragmentTag);
            ft.addToBackStack(fragmentTag);
            ft.commit();
        }
    }

    private void replaceFragmentWithoutBackstack(Fragment fragment) {
        String fragmentTag = fragment.getClass().getName();
        boolean fragmentPopped = getFragmentManager().popBackStackImmediate(fragmentTag, 0);
        if (!fragmentPopped) {
            // Fragment not in back stack, create it
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment, fragmentTag);
            ft.commit();
        }
        updateNavigationView(fragment);
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

    private void updateNavigationView(Fragment fragment) {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (null != navigationView) {
            if (fragment instanceof BouquetListFragment) {
                navigationView.getMenu().findItem(R.id.nav_bouquets).setChecked(true);
            } else if (fragment instanceof SettingsFragment) {
                navigationView.getMenu().findItem(R.id.nav_settings).setChecked(true);
            }
        }
    }
}
