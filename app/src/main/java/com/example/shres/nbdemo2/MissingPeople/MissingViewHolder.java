package com.example.shres.nbdemo2.MissingPeople;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shres.nbdemo2.News_java.NewsItems;
import com.example.shres.nbdemo2.R;
import com.squareup.picasso.Picasso;

public class MissingViewHolder  extends RecyclerView.ViewHolder {

    View mview;
    public MissingViewHolder( View itemView) {
        super(itemView);
        mview =itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mclickListner.onitemClick(v ,getAdapterPosition());
            }
        });



    }

   public void setDetails(Context ctx,String title,String name,String image,String age,String discription){


        //views
       TextView mtitle = mview.findViewById(R.id.rTitle);
        TextView mname = mview.findViewById(R.id.rname);
        ImageView mimage = mview.findViewById(R.id.rImageView);
        TextView mage = mview.findViewById(R.id.rage);
       TextView mdiscription = mview.findViewById(R.id.rdiscription);



       //set data to views

        mname.setText(name);
        Picasso.get().load(image).into(mimage);
        mage.setText(age);
       mtitle.setText(title);
       mdiscription.setText(discription);




    }
    private MissingViewHolder.clickListner mclickListner ;

    public interface clickListner{
        void onitemClick(View view , int positiion);

    }
    public void setOnClickListner(MissingViewHolder.clickListner clickListner){
        mclickListner=clickListner;
    }

}
