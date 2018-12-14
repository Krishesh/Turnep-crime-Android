package com.example.shres.nbdemo2.Fragements.NavBar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shres.nbdemo2.MissingPeople.MissingPeopleItems;
import com.example.shres.nbdemo2.MissingPeople.MissingViewHolder;
import com.example.shres.nbdemo2.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class MissingPeople extends Fragment {

    RecyclerView mrecyclerView;
    FirebaseDatabase mfirebaseDatabase;
    DatabaseReference databaseReference;


    public MissingPeople() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_missing_people, container, false);
        //recycler view
        mrecyclerView = view.findViewById(R.id.missing_recycler);
        mrecyclerView.setHasFixedSize(true);


        //set layout Linearlayout

        mrecyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));

        //send query to firebasedatabase
        mfirebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference=mfirebaseDatabase.getReference("missingPeople");

        //load data into recyclerview onStart




        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<MissingPeopleItems,MissingViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<MissingPeopleItems, MissingViewHolder>(
                        MissingPeopleItems.class,
                        R.layout.missing_people_model,
                        MissingViewHolder.class,
                        databaseReference
                ) {
                    @Override
                    protected void populateViewHolder(MissingViewHolder viewHolder, MissingPeopleItems model, int position) {
                            viewHolder.setDetails(getContext(),model.getTitle(),model.getDiscription(),model.getImage());

                    }
                };


        //set adapter to rectcler

        mrecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
