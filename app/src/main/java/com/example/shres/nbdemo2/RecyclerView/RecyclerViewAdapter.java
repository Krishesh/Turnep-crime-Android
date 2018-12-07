package com.example.shres.nbdemo2.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shres.nbdemo2.R;

import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewHolder>{

    private List<ItemObject> itemList;
    private Context context;

    public RecyclerViewAdapter(List<ItemObject> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_model,null);
        RecyclerViewHolder holder = new RecyclerViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.image.setImageResource(itemList.get(position).getImage());
        holder.text.setText(itemList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
