package com.example.shres.nbdemo2.News_java;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shres.nbdemo2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.view.View.GONE;

public class NewsViewAdapter extends ArrayAdapter<NewsItems> {

    private Context mContext;
    private int layoutResourceId;

    private ArrayList<NewsItems> mListData = new ArrayList<NewsItems>();

    public NewsViewAdapter(Context mContext, int layoutResourceId, ArrayList<NewsItems> mListData) {
        super(mContext, layoutResourceId, mListData);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.mListData = mListData;
    }


    /**
     * Updates grid data and refresh grid items.
     *
     * @parag mListData
     */
    public void setListData(ArrayList<NewsItems> mListData) {
        this.mListData = mListData;
        notifyDataSetChanged();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        NewsViewAdapter.ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new NewsViewAdapter.ViewHolder();
            holder.titleTextView = (TextView) row.findViewById(R.id.list_item_title);
            holder.imageView = (ImageView) row.findViewById(R.id.list_item_image);
            holder.descriptionTextView = (TextView) row.findViewById(R.id.list_item_description);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }


        NewsItems item = mListData.get(position);

        if (!TextUtils.isEmpty(Html.fromHtml(item.getTitle()))) {

            holder.titleTextView.setText(Html.fromHtml(item.getTitle()));

        } else {
            holder.titleTextView.setVisibility(GONE);
        }
        if ((item.getDescription()).toString() != "null") {
            holder.descriptionTextView.setText(Html.fromHtml(item.getDescription()));
        } else {
            holder.descriptionTextView.setVisibility(GONE);
        }
        if ((item.getImage()).toString() != "null" && !TextUtils.isEmpty(item.getImage())) {
            Picasso.get().load(item.getImage()).into(holder.imageView);
        } else {
            holder.imageView.setImageResource(R.drawable.background);
        }
        return row;

    }

    static class ViewHolder {
        TextView titleTextView;
        ImageView imageView;
        TextView descriptionTextView;
        TextView date;
        TextView auther;

    }
}
