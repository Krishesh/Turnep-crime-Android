package com.example.shres.nbdemo2.Fragements.BottomNavBar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shres.nbdemo2.R;


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

       /* RecyclerView recyclerView = view.findViewById(R.id.navigation_home);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
*/
        return view;
    }

}
