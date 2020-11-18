package com.example.practicetestapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Toolbar main_toolbar;
    SearchView main_searchView;
    DrawerLayout main_drawer;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_toolbar = findViewById(R.id.main_toolbar);
        main_searchView = findViewById(R.id.main_searchView);
        main_drawer = findViewById(R.id.main_drawer);

    }
}