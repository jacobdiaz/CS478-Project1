package com.jdiaz88.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GetLegalNameActivity extends AppCompatActivity {

    private EditText nameTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_legal_name);
        getSupportActionBar().hide(); // Hides the title bar

        nameTextField = findViewById(R.id.nameTextField);

        // Listen for "done" to be pressed on keyboard
        nameTextField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                int result = actionId & EditorInfo.IME_MASK_ACTION;
                if(result == EditorInfo.IME_ACTION_DONE) {
                    if(isValidLegalName()){
                       createLegalNameIntent();
                    } else {
                        Toast.makeText(GetLegalNameActivity.this, "Error not a valid name :(", Toast.LENGTH_SHORT).show();
                        setResult(RESULT_CANCELED);
                    }
                }
                return false;
            }
        });
    }
    private void createLegalNameIntent(){
        Toast.makeText(GetLegalNameActivity.this, "You have a valid name!", Toast.LENGTH_SHORT).show();

        // Create new intent with legal name
        Intent resultIntent = new Intent();
        resultIntent.putExtra("legalName",nameTextField.getText().toString());

        // Path the intent back to the main activity
        setResult(RESULT_OK,resultIntent);
        finish();
    }
    public boolean isValidLegalName() {
        /*
        * a valid name must....
        * NOT CONTAIN NUMBERS
        * MUST CONTAIN A SPACE
        */

        String legalName = nameTextField.getText().toString();
        if(legalName.contains(" ") && !(legalName.matches(".*\\d.*"))){
            return true;
        }
        return false;
    }
}