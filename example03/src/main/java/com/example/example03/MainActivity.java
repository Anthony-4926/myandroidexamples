package com.example.example03;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements NavController.OnDestinationChangedListener{
    private NavController controller;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        controller = Navigation.findNavController(this, R.id.my_nav_host_fragment);
        // 监听导航切换事件
        controller.addOnDestinationChangedListener(this);
        NavigationUI.setupWithNavController(bottomNavigationView, controller);
    }

    @Override
    public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
        switch (destination.getId()) {
            case R.id.fourthFragment:
                bottomNavigationView.setVisibility(View.GONE);
                break;
            default:
                bottomNavigationView.setVisibility(View.VISIBLE);
        }
    }
}
