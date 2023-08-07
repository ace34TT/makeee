package com.aceky.makeee.view.screens.destination;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aceky.makeee.R;

public class DestinationActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new ProvinceListFragment())
                    .commit();
        }
    }


}