package com.bee.dtbs.mobile.android.dtbsandroidclient.dtbsandroidclient.controller.driver;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.bee.dtbs.mobile.android.dtbsandroidclient.dtbsandroidclient.controller.AboutFragment;
import com.bee.dtbs.mobile.android.dtbsandroidclient.dtbsandroidclient.controller.LoginActivity;
import com.bee.dtbs.mobile.android.dtbsandroidclient.dtbsandroidclient.controller.SettingsFragment;
import com.bee.dtbs.mobile.android.dtbsandroidclient.dtbsandroidclient.controller.booking.history.BookingHistoryFragment;
import com.bee.dtbs.mobile.android.dtbsandroidclient.dtbsandroidclient.model.Account;

public class DriverActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView txtUsername;
    private TextView txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.bee.dtbs.mobile.android.dtbsandroidclient.R.layout.activity_driver);
        Toolbar toolbar = (Toolbar) findViewById(com.bee.dtbs.mobile.android.dtbsandroidclient.R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(com.bee.dtbs.mobile.android.dtbsandroidclient.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, com.bee.dtbs.mobile.android.dtbsandroidclient.R.string.navigation_drawer_open, com.bee.dtbs.mobile.android.dtbsandroidclient.R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(com.bee.dtbs.mobile.android.dtbsandroidclient.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(com.bee.dtbs.mobile.android.dtbsandroidclient.R.id.content_driver_frame, new DriverMapFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(com.bee.dtbs.mobile.android.dtbsandroidclient.R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.bee.dtbs.mobile.android.dtbsandroidclient.R.menu.driver, menu);
        txtUsername = (TextView)findViewById(com.bee.dtbs.mobile.android.dtbsandroidclient.R.id.txt_username);
        txtUsername.setText(Account.getInstance().getCommonName() + " " + Account.getInstance().getFamilyName());
        txtEmail = (TextView)findViewById(com.bee.dtbs.mobile.android.dtbsandroidclient.R.id.txt_email_address);
        txtEmail.setText(Account.getInstance().getEmail());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.bee.dtbs.mobile.android.dtbsandroidclient.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Called whenever a navigation item is selected.
     *
     * @param item item pressed.
     * @return True if the event was handled, false otherwise.
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment = null;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch(id){

            case com.bee.dtbs.mobile.android.dtbsandroidclient.R.id.taxi_bookings:
                fragment = new DriverMapFragment();
                break;
            case com.bee.dtbs.mobile.android.dtbsandroidclient.R.id.logout:
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
                break;
            case com.bee.dtbs.mobile.android.dtbsandroidclient.R.id.taxi_history:
                fragment = new BookingHistoryFragment();
                break;
            case com.bee.dtbs.mobile.android.dtbsandroidclient.R.id.about:
                fragment = new AboutFragment();
                break;
            case com.bee.dtbs.mobile.android.dtbsandroidclient.R.id.settings:
                fragment = new SettingsFragment();
        }

        // replace fragment if event handled.
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(com.bee.dtbs.mobile.android.dtbsandroidclient.R.id.content_driver_frame, fragment).commit();
        }else{
            return false;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(com.bee.dtbs.mobile.android.dtbsandroidclient.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
