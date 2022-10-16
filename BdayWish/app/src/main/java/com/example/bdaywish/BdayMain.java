package com.example.bdaywish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;

public class BdayMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bday_main);

        EditText txt_name = findViewById(R.id.txt_name);

        Intent intent = getIntent();

        String setName = intent.getStringExtra("passData");

        Toast.makeText(getBaseContext(), "name"+ setName, Toast.LENGTH_SHORT).show();

        txt_name.setText(setName);



    }
}