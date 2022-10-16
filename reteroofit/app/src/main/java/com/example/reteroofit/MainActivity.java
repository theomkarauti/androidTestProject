package com.example.reteroofit;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button =findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Methods methods = RetrofitClient.getRetrofitInsatance().create(Methods.class);
                Call<Model> call= methods.getAllData();

                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {


                        Log.e( TAG,"response"+response.code());

                        ArrayList<Model.data> data = response.body().getData();

                        for (Model.data data1 : data) {


                            Log.e( TAG,"response2"+data1.getEmail());
                        }
                        

                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {

                    }
                });


            }
        });




    }


}