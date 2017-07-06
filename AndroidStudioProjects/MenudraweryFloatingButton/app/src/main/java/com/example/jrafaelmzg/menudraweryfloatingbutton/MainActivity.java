package com.example.jrafaelmzg.menudraweryfloatingbutton;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fabBoton1);
        FloatingActionButton mCallbutton = (FloatingActionButton)findViewById(R.id.callbutton);
        FloatingActionButton mSMSbutton = (FloatingActionButton)findViewById(R.id.smsbutton);
        final LinearLayout mCalllayout = (LinearLayout)findViewById(R.id.calllayout);
        final LinearLayout mSmslayout = (LinearLayout)findViewById(R.id.smslayout);
        final Animation mShowButton= AnimationUtils.loadAnimation(MainActivity.this, R.anim.show_button);
        final Animation mHideButton= AnimationUtils.loadAnimation(MainActivity.this, R.anim.hide_button);
        final Animation mShowLayout= AnimationUtils.loadAnimation(MainActivity.this, R.anim.show_layout);
        final Animation mHideLayout= AnimationUtils.loadAnimation(MainActivity.this, R.anim.hide_layout);


        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCalllayout.getVisibility()== View.VISIBLE && mSmslayout.getVisibility()== View.VISIBLE){
                    mCalllayout.setVisibility(View.GONE);
                    mSmslayout.setVisibility(View.GONE);
                    mCalllayout.startAnimation(mHideLayout);
                    mSmslayout.startAnimation(mHideLayout);
                    fab2.startAnimation(mHideButton);
                }else{
                    mCalllayout.setVisibility(View.VISIBLE);
                    mSmslayout.setVisibility(View.VISIBLE);
                    mCalllayout.startAnimation(mShowLayout);
                    mSmslayout.startAnimation(mShowLayout);
                    fab2.startAnimation(mShowButton);
                }

            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
