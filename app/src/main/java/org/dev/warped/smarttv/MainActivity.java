package org.dev.warped.smarttv;

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

import static timber.log.Timber.DebugTree;

public class MainActivity extends AppCompatActivity
        implements FragmentManager.OnBackStackChangedListener, NavigationView.OnNavigationItemSelectedListener, BouquetListFragment.OnBouquetListFragmentInteractionListener {

    private static final String FRAGMENT_TAG_BOUQUETS = "FRAGMENT_TAG_BOUQUETS";
    private static final String FRAGMENT_TAG_SETTINGS = "FRAGMENT_TAG_SETTINGS";

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
            // Initialize Timber
            if (BuildConfig.DEBUG) {
                Timber.plant(new DebugTree());
            }

            // Ensures that the application is properly initialized with default settings
            PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

            // show bouquet list fragment on initial startup
            navigationView.getMenu().findItem(R.id.nav_bouquets).setChecked(true);
            BouquetListFragment fragment = new BouquetListFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment, FRAGMENT_TAG_BOUQUETS);
            transaction.commit();
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
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (null != navigationView) {
            BouquetListFragment bouquetListFragment = (BouquetListFragment) getFragmentManager().findFragmentByTag(FRAGMENT_TAG_BOUQUETS);
            if (null != bouquetListFragment && bouquetListFragment.isVisible()) {
                navigationView.getMenu().findItem(R.id.nav_bouquets).setChecked(true);
            }
            SettingsFragment settingsFragment = (SettingsFragment) getFragmentManager().findFragmentByTag(FRAGMENT_TAG_SETTINGS);
            if (null != settingsFragment && settingsFragment.isVisible()) {
                navigationView.getMenu().findItem(R.id.nav_settings).setChecked(true);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_todo) {
            Timber.d("onOptionsItemSelected: item %s selected.", getResources().getString(R.string.action_todo));
            return true;
        }
        else {
            Timber.w("onOptionsItemSelected: invalid item %d selected.", id);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_bouquets) {
            Timber.d("onNavigationItemSelected: item %s selected.", getResources().getString(R.string.menu_bouquets));
            showBouquets();
        } else if (id == R.id.nav_settings) {
            Timber.d("onNavigationItemSelected: item %s selected.", getResources().getString(R.string.menu_settings));
            showSettings();
        } else {
            Timber.w("onNavigationItemSelected: invalid item %d selected.", id);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showBouquets() {
        BouquetListFragment fragment = new BouquetListFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment, FRAGMENT_TAG_BOUQUETS);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void showSettings() {
        SettingsFragment fragment = new SettingsFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment, FRAGMENT_TAG_SETTINGS);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onShowBouquet(Bouquet bouquet) {
        Timber.d("onShowBouquet: \"%s\".", bouquet.getName());
    }
}
