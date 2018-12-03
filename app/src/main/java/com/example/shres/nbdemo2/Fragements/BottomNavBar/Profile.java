package com.example.shres.nbdemo2.Fragements.BottomNavBar;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shres.nbdemo2.Activity.LoginActivity;
import com.example.shres.nbdemo2.Activity.NavigationDrawerActivity;
import com.example.shres.nbdemo2.Activity.SignUpActivity;
import com.example.shres.nbdemo2.R;

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

//        if (sp.getBoolean("logged", false)) {
//            Intent intent = new Intent(getActivity(), SignUpActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
//        }

            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_profile, container, false);



    }


}
