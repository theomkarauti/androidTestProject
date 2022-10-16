package com.example.db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2;
    Button b1;

    FirebaseDatabase db= FirebaseDatabase.getInstance();
    DatabaseReference root =db.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1= findViewById(R.id.t1);

        t2= findViewById(R.id.t1);



        b1 = findViewById(R.id.btn);

        String txt_boxFirst = t1.getText().toString();

        String txt_boxSecond = t1.getText().toString();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                root.setValue(txt_boxFirst);
                Toast.makeText(getApplicationContext(), "Value set...:", Toast.LENGTH_SHORT).show();



            }
        });







    }
}