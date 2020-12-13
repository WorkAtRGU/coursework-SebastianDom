package com.example.mediaplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class planner1 extends AppCompatActivity {

    EditText title;
    EditText location;
    EditText description;
    Button addEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);

        title = findViewById(R.id.et_planner_title);
        location = findViewById(R.id.et_planner_location);
        description = findViewById(R.id.et_movie_description);
        addEvent = findViewById(R.id.btn_add_event);


        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!title.getText().toString().isEmpty() && !location.getText().toString().isEmpty() && !description.getText().toString().isEmpty()){

                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setData(CalendarContract.Events.CONTENT_URI);
                    intent.putExtra(CalendarContract.Events.TITLE, title.getText().toString());
                    intent.putExtra(CalendarContract.Events.EVENT_LOCATION, location.getText().toString());
                    intent.putExtra(CalendarContract.Events.DESCRIPTION, description.getText().toString());
                    intent.putExtra(CalendarContract.Events.ALL_DAY, "true");
                    intent.putExtra(Intent.EXTRA_EMAIL, "test@test.com");

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }else{
                        Toast.makeText(planner1.this, "There is no app that can support this action", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(planner1.this, "Please fill all of the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onClick(View view){
        // If the home button gets clicked it launches the corresponding activity
        if(view.getId() == R.id.btn_home){
            // Create the intent using application context
            // and the Class of the activity to launch
            Intent intent = new Intent(getApplicationContext(),
                    MainActivity.class);
            // Start the activity
            startActivity(intent);
        }
    }

}