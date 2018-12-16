package com.example.shres.nbdemo2.Fragements.BottomNavBar;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shres.nbdemo2.LoginAndRegistration.Settings_profile;
import com.example.shres.nbdemo2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {



    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ImageView imageView = view.findViewById(R.id.profile_settings);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),Settings_profile.class);
                startActivity(in);

            }
        });


        return view;





    }


}
