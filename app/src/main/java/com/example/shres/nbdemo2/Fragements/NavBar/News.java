package com.example.shres.nbdemo2.Fragements.NavBar;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.shres.nbdemo2.R;
import com.example.shres.nbdemo2.RecyclerView.News_object;
import com.example.shres.nbdemo2.RecyclerView.RecyclerViewAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class News extends Fragment {

    private List<News_object> newsObjects;
    private RecyclerView recyclerView;
    View v;
    ProgressDialog progress;
    private RecyclerViewAdapter recyclerViewAdapter;


   final List<News_object> newsdata = new ArrayList<News_object>();
    List<String> mdatakey = new ArrayList<>();

    public News() {
        // Required empty public constructor
    }


    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsObjects = new ArrayList<News_object>();

        newsObjects.add(new News_object("Sanjaya Lama","Graft case at Special Court against 21 persons including ex-minister Pandey","Dec 07 2018"));
        newsObjects.add(new News_object("Sanjaya Lama","Graft case at Special Court against 21 persons including ex-minister Pandey","Dec 07 2018"));
        newsObjects.add(new News_object("Sanjaya Lama","Graft case at Special Court against 21 persons including ex-minister Pandey","Dec 07 2018"));
        newsObjects.add(new News_object("Sanjaya Lama","Graft case at Special Court against 21 persons including ex-minister Pandey","Dec 07 2018"));
        newsObjects.add(new News_object("Sanjaya Lama","Graft case at Special Court against 21 persons including ex-minister Pandey","Dec 07 2018"));



    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_news, container, false);

        recyclerView=(RecyclerView) view.findViewById(R.id.news_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewAdapter = new RecyclerViewAdapter(newsObjects,getActivity());
        recyclerView.setAdapter(recyclerViewAdapter);
        super.onViewCreated(view, savedInstanceState);



        // progress dialoge for slow connection
        progress = new ProgressDialog(getActivity());
        progress.setTitle("Loading");
        progress.setMessage("Syncing");
        progress.setCancelable(false);
        load_news();


        return view;
    }

  /*  @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.v=view;

        Recycler_class();

        // progress dialoge for slow connection
        progress = new ProgressDialog(getActivity());
        progress.setTitle("Loading");
        progress.setMessage("Syncing");
        progress.setCancelable(false);

        load_news();

    }
*/
    private void load_news() {
        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("news");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                newsdata.clear();


                for (DataSnapshot single:dataSnapshot.getChildren()){
                    News_object newsObject = single.getValue(News_object.class);

                    newsdata.add(newsObject);


                }
                recyclerViewAdapter.notifyDataSetChanged();
                progress.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
/*
    private void Recycler_class() {

        recyclerView=v.findViewById(R.id.news_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewAdapter = new RecyclerViewAdapter(newsObjects,getActivity());
        recyclerView.setAdapter(recyclerViewAdapter);

    }*/
}
