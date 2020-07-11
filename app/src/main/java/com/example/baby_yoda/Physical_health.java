package com.example.baby_yoda;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Physical_health extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.physical_health);
        BottomNavigationView bnv = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this, R.id.fragment);

        NavigationUI.setupWithNavController(bnv, navController);
        NavigationUI.setupActionBarWithNavController(this, navController);
// <<<<<<< master
        navController.addOnDestinationChangedListener((NavController.OnDestinationChangedListener) this);


    }
}
