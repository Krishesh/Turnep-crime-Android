package com.example.shres.nbdemo2.RecyclerView;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shres.nbdemo2.R;

class RecyclerViewHolder extends RecyclerView.ViewHolder  {
    public ImageView image;
    public TextView text;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        text= itemView.findViewById(R.id.text);
        itemView.setOnClickListener((View.OnClickListener) this);
    }
}
