package com.example.memeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lodmeme();
    }



    String imageUrl;
    private void lodmeme(){


        ImageView imageView = findViewById(R.id.imageView);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://meme-api.herokuapp.com/gimme";

        // Request a string response from the provided URL.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                             imageUrl = response.getString("url");
                            Toast.makeText(MainActivity.this, "URL"+imageUrl, Toast.LENGTH_SHORT).show();
                            Glide.with(MainActivity.this).load(imageUrl).into(imageView);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);
    }

    public void shareMeme(View view) {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);

        Intent shareIntent = Intent.createChooser(sendIntent, "Sahre These meme using");
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send." +imageUrl );

        sendIntent.setType("text/plain");
        startActivity(shareIntent);
    }

    public void nxtBtn(View view) {

        lodmeme();
    }
}