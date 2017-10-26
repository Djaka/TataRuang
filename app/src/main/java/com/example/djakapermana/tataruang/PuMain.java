package com.example.djakapermana.tataruang;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.djakapermana.tataruang.fragments.HalamanUtamaFragment;
import com.example.djakapermana.tataruang.fragments.PerbupFragment;
import com.example.djakapermana.tataruang.fragments.PerdaFragment;
import com.example.djakapermana.tataruang.fragments.PerjalananDinasFragment;
import com.example.djakapermana.tataruang.fragments.InformasiRuangFragment;
import com.example.djakapermana.tataruang.fragments.ProfileFragment;
import com.example.djakapermana.tataruang.model.InformasiRuang;

public class PuMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_default, new HalamanUtamaFragment()).commit();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_tentang) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_default, new TentangAplikasiFragment()).commit();
            setTitle(R.string.s_tentang_aplikasi);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_dashboard){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_default, new HalamanUtamaFragment())
                    .addToBackStack(null)
                    .commit();
            setTitle(R.string.app_name);
        }
        else if (id == R.id.nav_profile){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_default, new ProfileFragment()).commit();
            setTitle(R.string.s_profile);
        }
        else if (id == R.id.nav_perda_rt_rw) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_default, new PerdaFragment()).commit();
            setTitle(R.string.s_perda_rt_rw);
        }
        else if (id == R.id.nav_perbup_rt_rw) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_default, new PerbupFragment()).commit();
            setTitle(R.string.s_perbup_rt_rw);
        }
        else if (id == R.id.nav_info_ruang) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_default, new InformasiRuangFragment()).commit();
            setTitle(R.string.s_info_ruang);

        }
        else if (id == R.id.nav_pola_ruang) {
            Intent intentPola = new Intent(Intent.ACTION_VIEW);
            intentPola.setData(Uri.parse("https://goo.gl/J56uho"));
            startActivity(intentPola);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
