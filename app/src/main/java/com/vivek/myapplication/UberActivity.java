package com.vivek.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uber);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.bottom_container, UberBottomFragment.Companion.newInstance())
                    .commit();
        }
    }
}
