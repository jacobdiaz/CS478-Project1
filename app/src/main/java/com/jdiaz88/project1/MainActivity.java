// Jacob Diaz
// Jdiaz88@uic.edu
// Project 1
package com.jdiaz88.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); // Hides the title bar
    }


    public void handleButtonOneClicked(View view) {
        startActivity(new Intent(MainActivity.this, GetLegalNameActivity.class));
    }

    public void handleButtonTwoClicked(View view) {

    }
}