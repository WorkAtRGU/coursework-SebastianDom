package com.example.mediaplanner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class movies1 extends AppCompatActivity {

    public static final String TAG = "mytag";

    EditText searchBar;
    Button btnSearch;
    RecyclerView recyclerView;
    RequestQueue requestQueue;
    String url;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        recyclerView = findViewById(R.id.rv_movie_list);
        searchBar = findViewById(R.id.et_searchbar);
        btnSearch = findViewById(R.id.btn_search_movie);



    }

    private void parseJsonData(){
        requestQueue = Volley.newRequestQueue(this);
        name = searchBar.getText().toString();

        url = "http://www.omdbapi.com/?t=Star+Wars&plot=full&apikey=e394550a";

        StringRequest request = new StringRequest(Request.Method.GET, url, new
                Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(movies1.this, ""+ response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);

    }


    public void onClick(View view){
        // If the home button gets clicked it launches the corresponding activity
        if(view.getId() == R.id.btn_home){
            Log.i(TAG, "Bye ");
            // Create the intent using application context
            // and the Class of the activity to launch
            Intent intent = new Intent(getApplicationContext(),
                    MainActivity.class);
            // Start the activity
            startActivity(intent);
        }
        if(view.getId() == R.id.btn_search_movie){
            Log.i(TAG, "Button ");
            parseJsonData();
        }
    }








}