package com.example.practicetestapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    Toolbar main_toolbar;
    SearchView main_searchView;
    DrawerLayout main_drawer;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartDialog();

        main_toolbar = findViewById(R.id.main_toolbar);
        main_searchView = findViewById(R.id.main_searchView);
        main_drawer = findViewById(R.id.main_drawer);

        setSupportActionBar(main_toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, main_drawer, main_toolbar, 0, 0);
        main_drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

    private void StartDialog() {
        AlertDialog.Builder ad_builder = new AlertDialog.Builder(MainActivity.this);
        ViewGroup ad_viewGroup = findViewById(R.id.main_layout);
        View ad_View = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_main, ad_viewGroup, false);
        ad_builder.setView(ad_View);
        AlertDialog ad_dialog = ad_builder.create();
        ad_dialog.setCanceledOnTouchOutside(false);
        ad_dialog.setCancelable(false);
        ad_dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        ad_dialog.show();
        ad_dialog.getWindow().findViewById(R.id.ad_cancel).setOnClickListener(view -> ad_dialog.dismiss());
    }
}