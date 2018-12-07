package com.example.shres.nbdemo2.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shres.nbdemo2.R;

import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private List<News_object> news_list;
    private Context context;

    public RecyclerViewAdapter(List<News_object> news_list, Context context) {
        this.news_list = news_list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_news,viewGroup,false);
        MyViewHolder viewHolder = new MyViewHolder(v);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int i) {

        holder.tv_news.setText(news_list.get(i).getNews_text());
        holder.tv_auther.setText(news_list.get(i).getName());
        holder.tv_date.setText(news_list.get(i).getDate());


    }

    @Override
    public int getItemCount() {
        return news_list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_news;
        TextView tv_auther;
        TextView tv_date;


        public MyViewHolder( View itemView) {
            super(itemView);
            tv_news = itemView.findViewById(R.id.news_text);
            tv_auther = itemView.findViewById(R.id.auther);
            tv_date = itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
