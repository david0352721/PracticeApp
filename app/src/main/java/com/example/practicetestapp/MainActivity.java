package com.example.practicetestapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.practicetestapp.fragment.HeartFragment;
import com.example.practicetestapp.fragment.HomeFragment;
import com.example.practicetestapp.fragment.MemberFragment;
import com.example.practicetestapp.fragment.NewsFragment;
import com.example.practicetestapp.fragment.ShopCarFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Toolbar main_toolbar;
    SearchView main_searchView;
    DrawerLayout main_drawer;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView main_navigationView;
    View main_logo;
    BottomNavigationView main_bottomNavigation;
    FrameLayout main_frame;
    Fragment[] fragments = new Fragment[5];
    int preFragmentFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartDialog();
        initView();
        initFragments();
        selectFragment();
        initData();

    }

    private void StartDialog() {
        AlertDialog.Builder ad_builder = new AlertDialog.Builder(MainActivity.this);
        ViewGroup ad_viewGroup = findViewById(R.id.main_drawer);
        View ad_View = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_main, ad_viewGroup, false);
        ad_builder.setView(ad_View);
        AlertDialog ad_dialog = ad_builder.create();
        ad_dialog.setCanceledOnTouchOutside(false);
        ad_dialog.setCancelable(false);
        ad_dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        ad_dialog.show();
        ad_dialog.getWindow().findViewById(R.id.ad_cancel).setOnClickListener(view -> ad_dialog.dismiss());
    }

    private void initView() {
        main_toolbar = findViewById(R.id.main_toolbar);
        main_searchView = findViewById(R.id.main_searchView);
        main_drawer = findViewById(R.id.main_drawer);
        main_navigationView = findViewById(R.id.main_navigationView);
        main_logo = findViewById(R.id.main_logo);
        main_bottomNavigation = findViewById(R.id.main_bottomNavigation);
        main_frame = findViewById(R.id.main_frame);
    }

    private void initFragments() {
        fragments[0] = new HomeFragment();
        fragments[1] = new NewsFragment();
        fragments[2] = new HeartFragment();
        fragments[3] = new ShopCarFragment();
        fragments[4] = new MemberFragment();
        initLoadFragment(R.id.main_frame, 0, fragments);
    }

    private void initData() {

        main_searchView.setIconifiedByDefault(false);
        main_searchView.setImeOptions(2);
        main_searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        main_logo.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_LONG).show();
            ShowAndHideFragment(fragments[0], fragments[preFragmentFlag]);
            preFragmentFlag = 0;
            main_bottomNavigation.setSelectedItemId(R.id.main_home);
        });

        setSupportActionBar(main_toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        actionBarDrawerToggle =
                new ActionBarDrawerToggle(MainActivity.this, main_drawer, main_toolbar, 0, 0);
        main_drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        main_navigationView.setItemIconTintList(null);
        main_navigationView.setNavigationItemSelectedListener(item -> {
            setDrawerClick(item.getItemId());
            item.setChecked(false);
            main_drawer.closeDrawers();
            return false;
        });

    }

    @SuppressLint("NonConstantResourceId")
    private void setDrawerClick(int itemId) {
        switch (itemId){
            case R.id.test1:
                Toast.makeText(MainActivity.this, "test1", Toast.LENGTH_LONG).show();
                break;
            case R.id.test2:
                Toast.makeText(MainActivity.this, "test2", Toast.LENGTH_LONG).show();
                break;
            case R.id.test3:
                Toast.makeText(MainActivity.this, "test3", Toast.LENGTH_LONG).show();
                break;
            case R.id.test4:
                Toast.makeText(MainActivity.this, "test4", Toast.LENGTH_LONG).show();
                break;
            case R.id.test5:
                Toast.makeText(MainActivity.this, "test5", Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void initLoadFragment(int containerID, int showFragment, @org.jetbrains.annotations.NotNull Fragment... fragments){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for(int i = 0; i < fragments.length; i++){
            transaction.add(containerID, fragments[i], fragments[i].getClass().getName());
            if (i != showFragment){
                transaction.hide(fragments[i]);
            }
        }

        transaction.commitAllowingStateLoss();

    }

    @SuppressLint("NonConstantResourceId")
    private void selectFragment(){
        main_bottomNavigation.setItemIconTintList(null);
        main_bottomNavigation.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){

                case R.id.main_home:
                    ShowAndHideFragment(fragments[0], fragments[preFragmentFlag]);
                    preFragmentFlag = 0;
                    break;

                case R.id.main_news:
                    ShowAndHideFragment(fragments[1], fragments[preFragmentFlag]);
                    preFragmentFlag = 1;
                    break;

                case R.id.main_heart:
                    ShowAndHideFragment(fragments[2], fragments[preFragmentFlag]);
                    preFragmentFlag = 2;
                    break;

                case R.id.main_shopCar:
                    ShowAndHideFragment(fragments[3], fragments[preFragmentFlag]);
                    preFragmentFlag = 3;
                    break;

                case R.id.main_member:
                    ShowAndHideFragment(fragments[4], fragments[preFragmentFlag]);
                    preFragmentFlag = 4;
                    break;

            }
            return true;
        });
    }

    private void ShowAndHideFragment(Fragment show, Fragment hide){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (show != hide){
            transaction.show(show).hide(hide).commitAllowingStateLoss();
        }
    }

}