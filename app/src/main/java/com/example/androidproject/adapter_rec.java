package com.example.androidproject;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.*;

public class adapter_rec extends RecyclerView.Adapter<adapter_rec.MyViewHolder> {
   Context context;
   ArrayList<user>list;

    public adapter_rec(Context context, ArrayList<user> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.item_design,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        user u =list.get(position);
        holder.item.setText(u.getItemname());
        holder.quantity.setText(u.getQuantity());
        holder.price.setText(u.getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item;
        TextView quantity;
        TextView price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item=itemView.findViewById(R.id.itemName);
            quantity=itemView.findViewById(R.id.Quantity);
            price=itemView.findViewById(R.id.Price);
        }
    }

}
