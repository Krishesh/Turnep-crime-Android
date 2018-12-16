package com.example.shres.nbdemo2.Fragements.BottomNavBar;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shres.nbdemo2.LoginAndRegistration.LoginActivity;
import com.example.shres.nbdemo2.LoginAndRegistration.SignUpActivity;
import com.example.shres.nbdemo2.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {

//    SharedPreferences sp;

    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        return view;





    }


}
