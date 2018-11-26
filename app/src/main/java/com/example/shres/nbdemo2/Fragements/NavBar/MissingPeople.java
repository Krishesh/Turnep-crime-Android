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
public class MissingPeople extends Fragment {


    public MissingPeople() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_missing_people, container, false);
    }

}
