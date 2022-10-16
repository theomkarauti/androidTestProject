package com.example.rv;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.telecom.TelecomManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerAdapter;
    SwipeRefreshLayout swipeRefreshLayout;

    List moviesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        recyclerView=findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerAdapter = new RecyclerAdapter(moviesList);
        recyclerView.setAdapter(recyclerAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        moviesList.add("Iron Man");
        moviesList.add("The Incredible Hulk");
        moviesList.add("The  Hulk");
        moviesList.add("Iron Man2");
        moviesList.add("Iron Man3");
        moviesList.add("Iron Man4");
        moviesList.add("Iron Man6");
        moviesList.add("Iron Man7");
        moviesList.add("Iron Man8");
        moviesList.add("Iron Man9");
        moviesList.add("Iron Man10");
        moviesList.add("Iron Man11");
        moviesList.add("Iron Man12");
        moviesList.add("Iron Man13");
        moviesList.add("Iron Man14");
        moviesList.add("Iron Man15");
        moviesList.add("Iron Man16");
        moviesList.add("Iron Man17");
        moviesList.add("Iron Man18");
        moviesList.add("Iron Man19");


      swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

      swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
          @Override
          public void onRefresh() {

              moviesList.add("Iron Women 21");
              moviesList.add("Iron Women 22");
              moviesList.add("Iron Women 23");
              moviesList.add("Iron Women 24");
            recyclerAdapter.notifyDataSetChanged();
            swipeRefreshLayout.setRefreshing(false);


          }
      });




    }
}