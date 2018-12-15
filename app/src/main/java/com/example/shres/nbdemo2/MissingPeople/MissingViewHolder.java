package com.example.shres.nbdemo2.MissingPeople;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shres.nbdemo2.R;
import com.squareup.picasso.Picasso;

public class MissingViewHolder  extends RecyclerView.ViewHolder {

    View mview;
    public MissingViewHolder( View itemView) {
        super(itemView);
        mview =itemView;

    }

   public void setDetails(Context ctx,String title,String name,String image){
        //views
        TextView mtitle = mview.findViewById(R.id.rTitle);
        TextView mname = mview.findViewById(R.id.rname);
        ImageView mimage = mview.findViewById(R.id.rImageView);
        //set data to views
        mtitle.setText(title);
        mname.setText(name);
        Picasso.get().load(image).into(mimage);



    }
}
