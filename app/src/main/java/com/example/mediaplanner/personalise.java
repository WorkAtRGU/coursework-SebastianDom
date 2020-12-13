package com.example.mediaplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class personalise extends AppCompatActivity {

    EditText name;
    Button button;
    SharedPreferences sp;
    String nameStr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalise);

        name = findViewById(R.id.et_my_name);
        button = findViewById(R.id.btn_save_preferences);

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameStr = name.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                editor.putString("name", nameStr);
                editor.commit();
                Toast.makeText(personalise.this, "information Saved.", Toast.LENGTH_LONG).show();
            }
        });


    }

    public void onClick(View view) {
        // If the home button gets clicked it launches the corresponding activity
        if (view.getId() == R.id.btn_prefs_home) {
            // Create the intent using application context
            // and the Class of the activity to launch
            Intent intent = new Intent(getApplicationContext(),
                    MainActivity.class);
            // Start the activity
            startActivity(intent);
        }

    }
}