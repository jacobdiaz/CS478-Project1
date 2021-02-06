package com.jdiaz88.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GetLegalNameActivity extends AppCompatActivity {

    EditText nameTextField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_legal_name);
        getSupportActionBar().hide(); // Hides the title bar

        nameTextField = findViewById(R.id.nameTextField);
        // Listen For enter key to be pressed =
        nameTextField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                int result = actionId & EditorInfo.IME_MASK_ACTION;

                if(result == EditorInfo.IME_ACTION_DONE) {
                    if(isValidLegalName()){
                        Toast.makeText(GetLegalNameActivity.this, "You have a valid name!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(GetLegalNameActivity.this, "Error not a valid name :(", Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });
    }

    public boolean isValidLegalName() {
        if(nameTextField.getText().toString().contains(" ")){
            return true;
        }
        return false;
    }
}