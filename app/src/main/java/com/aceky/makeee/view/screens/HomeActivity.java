package com.aceky.makeee.view.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.aceky.makeee.R;
import com.aceky.makeee.viewmodel.TouristDestinationViewModel;

public class HomeActivity extends AppCompatActivity {
    private TouristDestinationViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        model = new ViewModelProvider(this).get(TouristDestinationViewModel.class);
        model.getTouristDestination().observe(this, students -> {
            // update UI
        });
    }
}