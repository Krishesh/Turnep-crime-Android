package com.example.shres.nbdemo2.Fragements.BottomNavBar;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.shres.nbdemo2.R;
import java.util.ArrayList;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.shres.nbdemo2.Activity.NavigationDrawerActivity;



public class Home extends Fragment {
    ListView listView;
    ArrayList<String>  str;
    int[] images={
            R.drawable.news,
            R.drawable.missing_people,
            R.drawable.crime
    };

    String[] string ={
            "News",
            "Missing",
            "Crime"
    };



    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container,false);
        //listview
        listView = view.findViewById(R.id.homelistview);
        str= new ArrayList<String>();
        //Created custom adaptor
        final CustomAdaptor customAdaptor=new CustomAdaptor();
        listView.setAdapter(customAdaptor);
        //set a onItemClickListner
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                long s =customAdaptor.getItemId(position);

                NavigationDrawerActivity nav= (NavigationDrawerActivity) getActivity();
                nav.homeSwitch(s);
            }
        });

        return view;
    }

    class CustomAdaptor extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v= getLayoutInflater().inflate(R.layout.home_model,null);

            ImageView imageView = v.findViewById(R.id.home_images);
            TextView textView = v.findViewById(R.id.home_strings);

            imageView.setImageResource(images[position]);
            textView.setText(string[position]);

            return v;
        }
    }


}
