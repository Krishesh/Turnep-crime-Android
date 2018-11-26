package com.example.shres.nbdemo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridViewAdaptor extends BaseAdapter {
    Context mContext;
    ArrayList<Spacecraft> spacecrafts;


    public GridViewAdaptor(Context c, ArrayList<String> retrieve) {
        this.mContext = c;
        this.spacecrafts = spacecrafts ;
    }


    @Override
    public int getCount() {
        return spacecrafts.size();
    }

    @Override
    public Object getItem(int position) {
        return spacecrafts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



  /*  @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageView.setLayoutParams(new GridView.LayoutParams(getScreenWidth(), 600));
        return imageView;
    }*/


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.model, parent, false);
        }

        TextView nameTxt = (TextView) convertView.findViewById(R.id.nameTxt);
        TextView propTxt = (TextView) convertView.findViewById(R.id.address);
        TextView descTxt = (TextView) convertView.findViewById(R.id.phone_number);

        final Spacecraft s = (Spacecraft) this.getItem(position);

        nameTxt.setText(s.getName());
        propTxt.setText(s.getAddress());
        descTxt.setText(s.getPhonenumber());

        //ONITECLICK
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, s.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;


    /*private int getScreenWidth() {

        DisplayMetrics dm = new DisplayMetrics();

        int widthInDP = 0;

        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(dm);
        }
        widthInDP = Math.round(dm.widthPixels / dm.density);
        return widthInDP;
    }*/
    }
}
