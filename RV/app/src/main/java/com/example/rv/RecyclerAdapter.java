package com.example.rv;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder> {

    List<String> moviesList = new ArrayList<>();


    public static final String TAG ="RecycleAdapter";
    int count=0;

    public RecyclerAdapter(List moviesList) {
        this.moviesList = moviesList;


    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.i(TAG,"msg:"+count++);

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item,parent,false);
        viewHolder viewHolder = new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        int pos = position;

        holder.rowCountTextView.setText(String.valueOf(position));
        holder.textView.setText(moviesList.get(position));






    }

    @Override
    public int getItemCount()
    {
        return moviesList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView imageView;
        TextView textView,rowCountTextView;
         public viewHolder(@NonNull View itemView) {
             super(itemView);

             imageView = (itemView).findViewById(R.id.imageView);
             textView = (itemView).findViewById(R.id.textView);
             rowCountTextView = (itemView).findViewById(R.id.rowCountTextView);
//1st step implementation...

             itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
             @Override
             public boolean onLongClick(View v) {
                 moviesList.remove(getAdapterPosition());
                 notifyItemRemoved(getAdapterPosition());

                  return true;
             }
                });

         }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Movies:"+moviesList.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
    }
}
