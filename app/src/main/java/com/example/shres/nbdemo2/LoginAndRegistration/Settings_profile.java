package com.example.shres.nbdemo2.LoginAndRegistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shres.nbdemo2.R;
import com.google.firebase.auth.FirebaseAuth;

public class Settings_profile extends AppCompatActivity {
    Button signupButton;
    Button LoginButton;
    Button signoutButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_profile);signupButton =(Button) findViewById(R.id.signupbutton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Settings_profile.this,SignUpActivity.class);
                startActivity(in);

            }
        });
        LoginButton =(Button) findViewById(R.id.loginbutton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Settings_profile.this,LoginActivity.class);
                startActivity(in);

            }
        });
        signoutButton =(Button) findViewById(R.id.signout);
        signoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                Intent in = new Intent(Settings_profile.this, LoginActivity.class);
                startActivity(in);

            }
        });
    }
}
