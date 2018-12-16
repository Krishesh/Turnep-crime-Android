package com.example.shres.nbdemo2.LoginAndRegistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.shres.nbdemo2.R;

public class Settings_profile extends AppCompatActivity {
    Button signupButton;
    Button LoginButton;
    Button signoutButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_profile);
    }
}
