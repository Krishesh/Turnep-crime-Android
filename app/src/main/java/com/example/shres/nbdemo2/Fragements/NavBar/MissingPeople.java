package com.example.shres.nbdemo2.Fragements.NavBar;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shres.nbdemo2.MissingPeople.MissingPeopleItems;
import com.example.shres.nbdemo2.MissingPeople.MissingPersonActivity;
import com.example.shres.nbdemo2.MissingPeople.MissingViewHolder;
import com.example.shres.nbdemo2.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;


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
                            viewHolder.setDetails(getContext(),model.getTitle(),model.getName(),model.getImage(),model.getAge(),model.getDiscription());

                    }

                    @Override
                    public MissingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        MissingViewHolder missingViewHolder = super.onCreateViewHolder(parent,viewType);

                        missingViewHolder.setOnClickListner(new MissingViewHolder.clickListner() {
                            @Override
                            public void onitemClick(View view, int positiion) {
                                // views
                                TextView Name = view.findViewById(R.id.rname);
                                TextView Age = view.findViewById(R.id.rage);
                                TextView Diecription = view.findViewById(R.id.rdiscription);
                                TextView title = view.findViewById(R.id.rTitle);
                                ImageView image = view.findViewById(R.id.rImageView);

                                // set data
                                String sname = Name.getText().toString();
                                String sage = Age.getText().toString();
                                String sdiscription = Diecription.getText().toString();
                                String stitle = title.getText().toString();
                                Drawable sdrawable= image.getDrawable();
                                Bitmap sbitmap= ((BitmapDrawable)sdrawable).getBitmap();

                                //passing this data
                                Intent intent = new Intent(view.getContext(),MissingPersonActivity.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                sbitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
                                byte [] bytes= stream.toByteArray();
                                intent.putExtra("image",bytes);
                                intent.putExtra("name",sname);
                                intent.putExtra("age",sage);
                                intent.putExtra("discription",sdiscription);
                                intent.putExtra("title",stitle);
                                startActivity(intent);
                            }
                        });

                        return missingViewHolder;
                    }
                };


        //set adapter to rectcler

        mrecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
