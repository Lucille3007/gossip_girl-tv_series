package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<DataModel> dataset;
    public void setFilteredList(ArrayList<DataModel> filteredList) {
        this.dataset = filteredList;
        notifyDataSetChanged();
    }

    public CustomAdapter(ArrayList<DataModel> dataSet)
    {
        this.dataset = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewName;
        TextView textViewDescription;
        ImageView imageView;
        public MyViewHolder (View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textView);
            textViewDescription = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);

        MyViewHolder MyViewHolder = new MyViewHolder(view);
        return MyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        TextView textViewName = holder.textViewName;
        TextView textViewDescription = holder.textViewDescription;
        ImageView imageView = holder.imageView;

        textViewName.setText(dataset.get(position).getName());
        textViewDescription.setText(dataset.get(position).getDescription());
        imageView.setImageResource(dataset.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
