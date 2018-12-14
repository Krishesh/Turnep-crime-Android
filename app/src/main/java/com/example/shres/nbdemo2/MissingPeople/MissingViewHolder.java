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
    public MissingViewHolder(@NonNull View itemView) {
        super(itemView);
        mview =itemView;
    }

   public void setDetails(Context ctx,String title,String discription,String image){
        //views
        TextView mtitle = mview.findViewById(R.id.rTitle);
        TextView mdetails = mview.findViewById(R.id.rDiscription);
        ImageView mimage = mview.findViewById(R.id.rImageView);
        //set data to views
        mtitle.setText(title);
        mdetails.setText(discription);
        Picasso.get().load(image).into(mimage);



    }
}
