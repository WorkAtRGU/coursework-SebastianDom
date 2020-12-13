package com.example.mediaplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "mytag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t1;
        t1 = findViewById(R.id.tv_welcome_back);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String name = sp.getString( "name", "");
        t1.setText("Welcome back, " + name);
    }

    public void onClick(View view) {
        // If the movies button gets clicked it launches the corresponding activity
        if (view.getId() == R.id.btn_movies) {
            // Create the intent using application context
            // and the Class of the activity to launch
            Intent intent = new Intent(getApplicationContext(),
                    movies1.class);
            // Start the activity
            Log.i(TAG, "hello ");
            startActivity(intent);
        }

        // If the planner button gets clicked it launches the corresponding activity
        if (view.getId() == R.id.btn_planner) {
            // Create the intent using application context
            // and the Class of the activity to launch
            Intent intent = new Intent(getApplicationContext(),
                    planner1.class);
            // Start the activity
            startActivity(intent);
        }

        if (view.getId() == R.id.btn_personalise) {
            // Create the intent using application context
            // and the Class of the activity to launch
            Intent intent = new Intent(getApplicationContext(),
                    personalise.class);
            // Start the activity
            startActivity(intent);

        }
    }
}