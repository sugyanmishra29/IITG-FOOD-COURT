package com.example.foodcourt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recyclerviewadapter extends RecyclerView.Adapter<Recyclerviewadapter.ViewHolder> {


    private static final String TAG = "Recyclerviewadapter";
    private ArrayList<String> mshopnames=new ArrayList<>();
    private ArrayList<String> mshoplocations=new ArrayList<>();
    private ArrayList<String> mshoprating=new ArrayList<>();
    Context mcontext;

    public Recyclerviewadapter(ArrayList<String> mshopnames, ArrayList<String> mshoplocations, ArrayList<String> mshoprating, Context mcontext) {
        this.mshopnames = mshopnames;
        this.mshoplocations = mshoplocations;
        this.mshoprating = mshoprating;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.shoplist,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.shopname.setText(mshopnames.get(position));
        holder.shoplocation.setText(mshoplocations.get(position));
        holder.shoprating.setText(mshoprating.get(position));
    }

    @Override
    public int getItemCount() {
        return mshopnames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView shopname;
        TextView shoplocation;
        TextView shoprating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shopname=itemView.findViewById(R.id.shop_name);
            shoplocation=itemView.findViewById(R.id.shop_location);
            shoprating=itemView.findViewById(R.id.shop_rating);
        }
    }
}
