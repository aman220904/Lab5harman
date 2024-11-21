package com.example.lab5harman;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Harmandeep Kaur
 * @version 1.0
 */


public class MainActivity extends AppCompatActivity {

    /** This holds the output */
    private TextView tv = null;

    /** This holds the EditText for user input */
    private EditText et = null;

    /** This holds the Button to trigger actions */
    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        TextView tv = findViewById(R.id.textView);
        EditText et = findViewById(R.id.editText);
        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();
            if (checkPasswordComplexity(password)) {
                tv.setText("Your password meets the requirements.");
            } else {
                tv.setText("You shall not pass!");
            }
        });
    }

    /**
     * This function checks the complexity of a password.
     *
     * @param pw The String object that we are checking.
     * @return true if the password meets all criteria, false otherwise.
     */
    boolean checkPasswordComplexity(String pw) {
        boolean foundUpperCase = false;
        boolean foundLowerCase = false;
        boolean foundNumber = false;
        boolean foundSpecial = false;

        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);

            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }
        }

        if (!foundUpperCase) {
            Toast.makeText(this, "Password must include an uppercase letter.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(this, "Password must include a lowercase letter.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            Toast.makeText(this, "Password must include a number.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(this, "Password must include a special character.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true; // All criteria met
        }
    }

    /**
     * This function checks if a character is a special character.
     *
     * @param c The character to check.
     * @return true if the character is a special character, false otherwise.
     */
    boolean isSpecialCharacter(char c) {
        // Return true if the character is one of: #$%^&*!@?
        return "#$%^&*!@?".indexOf(c) != -1;
    }
}
