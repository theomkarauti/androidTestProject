package com.example.bdaywish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       Button btn_Submit = findViewById(R.id.btn_submit);
        EditText txt_Name = findViewById(R.id.txt_name);



        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txt_Name.getText().toString();

                Intent intent = new Intent(MainActivity.this,BdayMain.class);
               intent.putExtra("passData",name);
                startActivity(intent);



            }
        });





    }
}