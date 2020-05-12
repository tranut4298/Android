package com.example.test_20200424_version_100.MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.test_20200424_version_100.Class.ListView_Adapter;
import com.example.test_20200424_version_100.Class.Model_BB;
import com.example.test_20200424_version_100.R;
import com.example.test_20200424_version_100.ui.A.AFragment;
import com.example.test_20200424_version_100.ui.B.BFragment;
import com.example.test_20200424_version_100.ui.C.CFragment;
import com.example.test_20200424_version_100.ui.D.DFragment;
import com.example.test_20200424_version_100.ui.E.EFragment;
import com.example.test_20200424_version_100.ui.F.FFragment;
import com.example.test_20200424_version_100.ui.G.GFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    NavigationView navigationView;
    ArrayList<Model_BB> arrayList;
    ListView_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--Anh Xa
        AnhXa();

        //--Navigation
        navigationView  = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new BFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_1);
        }
        //--ToolBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    //---Anh Xa
    private void AnhXa() {

    }

    //---Action with Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem     = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Tên biển báo cần tìm!!");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.menuSetting){
            Toast.makeText(this, "Hello. That's Cu Lua!", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    //---Navigation
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_0:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new AFragment()).commit();
                break;
            case R.id.nav_1:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new BFragment()).commit();
                break;
            case R.id.nav_2:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new CFragment()).commit();
                break;
            case R.id.nav_3:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new DFragment()).commit();
                break;
            case R.id.nav_4:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new EFragment()).commit();
                break;
            case R.id.nav_5:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new FFragment()).commit();
                break;
            case R.id.nav_6:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new GFragment()).commit();
                break;
            case R.id.nav_11:
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
