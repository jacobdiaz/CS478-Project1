// Jacob Diaz
// Jdiaz88@uic.edu
// Project 1
// How to put contact into contacts app https://developer.android.com/training/contacts-provider/modify-data
package com.jdiaz88.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    TODO Create Lanscape Orientations for screens!!!!

    private static final int requestCode = 99;
    private TextView centerText;
    private TextView welcomeText;
    private boolean isValidLegalName;
    private String legalName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isValidLegalName = false;
        centerText = findViewById(R.id.isValidatedText);
        welcomeText = findViewById(R.id.welcomeHeader);

        getSupportActionBar().hide(); // Hides the title bar
    }


    public void handleButtonOneClicked(View view) {
//        startActivity(new Intent(MainActivity.this, GetLegalNameActivity.class));
            Intent i = new Intent(MainActivity.this, GetLegalNameActivity.class);
            i.putExtra("legalName","");
            startActivityForResult(i, requestCode);
    }

    public void handleButtonTwoClicked(View view) {
        if(isValidLegalName){
            Intent contactsIntent = new Intent(ContactsContract.Intents.Insert.ACTION);
            contactsIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

            contactsIntent.putExtra(ContactsContract.Intents.Insert.NAME, legalName);
            startActivity(contactsIntent);
        }
        else{
            Toast.makeText(this, "Please enter valid name by clicking Button One", Toast.LENGTH_SHORT).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);

        // Check if we sent that 99 request code
        if(requestCode == 99){
            // Check if we got an Ok result
            if(resultCode == RESULT_OK){
                // Get our data
                String result = i.getStringExtra("legalName");
                legalName = result;
                welcomeText.setText("Welcome "+legalName);
                centerText.setText("Name Validated!");
                isValidLegalName = true;
            }
            if(resultCode == RESULT_CANCELED){
                centerText.setText("Invalid Name");
                isValidLegalName = false;
            }

        }
    }
}