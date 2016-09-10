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
import android.view.Menu;
import android.view.MenuItem;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity
        implements FragmentManager.OnBackStackChangedListener,
        NavigationView.OnNavigationItemSelectedListener,
        BouquetListFragment.OnBouquetListFragmentInteractionListener,
        ChannelListFragment.OnChannelListFragmentInteractionListener,
        DeviceDiscoveryFragment.OnDeviceDiscoveryFragmentInteractionListener,
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
            // Ensures that the application is properly initialized with default settings
            PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

            if (SharedPreferencesManager.getReceiverAutoDiscovery(PreferenceManager.getDefaultSharedPreferences(this))) {
                // show device discovery fragment on initial startup
                DeviceDiscoveryFragment fragment = new DeviceDiscoveryFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment, fragment.getClass().getName());
                transaction.commit();
            } else {
                // show bouquet list fragment on initial startup
                navigationView.getMenu().findItem(R.id.nav_bouquets).setChecked(true);
                BouquetListFragment fragment = new BouquetListFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment, fragment.getClass().getName());
                transaction.commit();

                if (!SharedPreferencesManager.areSettingsDefined(PreferenceManager.getDefaultSharedPreferences(this))) {
                    replaceFragment(new SettingsFragment());
                    SnackBarFactory.showSnackBar(this, R.string.snackbar_please_define_settings);
                }
            }
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
    public void onShowBouquet(Bouquet bouquet) {
        Timber.d("onShowBouquet: \"%s\".", bouquet.getName());
        replaceFragment(ChannelListFragment.newInstance(bouquet));
    }

    @Override
    public void onShowChannel(Channel channel) {
        Timber.d("onShowChannel: \"%s\".", channel.getName());
        replaceFragment(EpgEventListFragment.newInstance(channel));
    }

    @Override
    public void onDeviceDiscoveryFinished() {
        Timber.d("onDeviceDiscoveryFinished:");
        replaceFragmentWithoutBackstack(new BouquetListFragment());
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
