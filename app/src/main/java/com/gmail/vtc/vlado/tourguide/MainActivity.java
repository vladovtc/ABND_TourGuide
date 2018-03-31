package com.gmail.vtc.vlado.tourguide;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.nav_view) NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mDrawerLayout();
        mFragmentManager();

    }

    private void mFragmentManager() {

        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragmentAdriatic = new AdriaticSeaFragment();
        fragmentTransaction.replace(R.id.frame_content, fragmentAdriatic);
        setTitle(getString(R.string.adriatic_sea));
        fragmentTransaction.commit();
    }


    /**
     * Add functionality to Drawer Layout
     */

    private void mDrawerLayout() {

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (id) {
            case R.id.nav_adriatic:
                Fragment fragmentAdriatic = new AdriaticSeaFragment();
                fragmentTransaction.replace(R.id.frame_content, fragmentAdriatic).commit();
                break;

            case R.id.nav_castles:
                Fragment fragmentCastles = new CastlesFragment();
                fragmentTransaction.replace(R.id.frame_content, fragmentCastles).commit();
                break;

            case R.id.nav_national_parks:
                Fragment fragmentNationalPark = new NationalParkFragment();
                fragmentTransaction.replace(R.id.frame_content, fragmentNationalPark).commit();
                break;

            case R.id.nav_museum:
                Fragment fragmentMuseum = new MuseumFragment();
                fragmentTransaction.replace(R.id.frame_content, fragmentMuseum).commit();
                break;
        }

        setTitle(item.getTitle());

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

