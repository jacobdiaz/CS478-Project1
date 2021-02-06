package com.jdiaz88.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GetLegalNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_legal_name);
        getSupportActionBar().hide(); // Hides the title bar
    }
}