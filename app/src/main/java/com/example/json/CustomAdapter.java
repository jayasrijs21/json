package com.example.json;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    ArrayList<String> name ;
    ArrayList<String> house;
    ArrayList<String> scimarks;
    ArrayList<String> extra;
    Context context;

    public CustomAdapter(ArrayList<String> name, ArrayList<String> house, ArrayList<String>scimarks,
                         ArrayList<String> extra, Context context) {
        this.name = name;
        this.house = house;
        this.scimarks = scimarks;
        this.extra = extra;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_layout , parent , false );
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.vhft.setText(name.get(position));
        holder.vhfi.setText(house.get(position));
        holder.vhbt.setText(scimarks.get(position));
        holder.vhet.setText(extra.get(position));


        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(context, name.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public int getItemCount() {
        return name.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView vhft , vhfi, vhbt,vhet;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            vhft = itemView.findViewById(R.id.tvName);
            vhfi = itemView.findViewById(R.id.tvHouse);
            vhbt = itemView.findViewById(R.id.tvScience);
            vhet = itemView.findViewById(R.id.tvExtra);

        }
    }
}
