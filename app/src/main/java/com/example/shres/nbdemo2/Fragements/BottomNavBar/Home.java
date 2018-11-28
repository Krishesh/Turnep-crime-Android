package com.example.shres.nbdemo2.Fragements.BottomNavBar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shres.nbdemo2.Fragements.NavBar.News;
import com.example.shres.nbdemo2.R;
import com.example.shres.nbdemo2.RecyclerView.ItemObject;
import com.example.shres.nbdemo2.RecyclerView.RecyclerItemClickListener;
import com.example.shres.nbdemo2.RecyclerView.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {



    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

}
