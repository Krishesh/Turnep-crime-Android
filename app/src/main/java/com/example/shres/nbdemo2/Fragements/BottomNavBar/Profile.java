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
         Button signupButton;
         Button LoginButton;
         Button signoutButton;


//        if (sp.getBoolean("logged", false)) {
//            Intent intent = new Intent(getActivity(), SignUpActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
//        }

            View view =inflater.inflate(R.layout.fragment_profile, container, false);

             signupButton =(Button) view.findViewById(R.id.signupbutton);
            signupButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(getActivity(),SignUpActivity.class);
                    startActivity(in);

                }
            });
        LoginButton =(Button) view.findViewById(R.id.loginbutton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),LoginActivity.class);
                startActivity(in);

            }
        });
        signoutButton =(Button) view.findViewById(R.id.signout);
        signoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                Intent in = new Intent(getActivity(),LoginActivity.class);
                startActivity(in);

            }
        });


            return view;
    }


}
