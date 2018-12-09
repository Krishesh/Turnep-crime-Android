package com.example.shres.nbdemo2.Fragements.NavBar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shres.nbdemo2.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class News extends Fragment {


    public News() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_news, container, false);



         return  view;

    }

}
