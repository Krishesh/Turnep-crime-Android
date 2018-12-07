package com.example.shres.nbdemo2.Fragements.NavBar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shres.nbdemo2.R;
import com.example.shres.nbdemo2.RecyclerView.ItemObject;
import com.example.shres.nbdemo2.RecyclerView.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class News extends Fragment {
    private LinearLayoutManager linearLayoutManager;
    private List<ItemObject> itemObjects;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<ItemObject> itemObject;

    public News() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_news, container, false);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);


        itemObjects = getItemObject();
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(itemObjects, getActivity());
        recyclerViewAdapter = new RecyclerViewAdapter(itemObjects,getActivity());
        recyclerView.setAdapter((RecyclerView.Adapter) recyclerViewAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter.notifyDataSetChanged();
       /* recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
        public void onItemClick(View view, int position) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain,new News());
            ft.commit();

        }

        @Override
        public void onLongItemClick(View view, int position) {

        }
    }));*/
        return view;
    }



    public List<ItemObject> getItemObject() {
        List<ItemObject> itemObjects = new ArrayList<ItemObject>();

        itemObjects.add(new ItemObject(R.drawable.news,"News"));
        itemObjects.add(new ItemObject(R.drawable.news,"Missing People"));
        itemObjects.add(new ItemObject(R.drawable.news,"Crime Report"));

        return itemObject;
    }




}
