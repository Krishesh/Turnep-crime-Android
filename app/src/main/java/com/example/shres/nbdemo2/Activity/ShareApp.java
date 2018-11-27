package com.example.shres.nbdemo2.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import android.support.v4.app.FragmentTransaction;
// import android.widget.Toast;

import com.example.shres.nbdemo2.R;

public class ShareApp extends AppCompatActivity {

    private ShareActionProvider mShareActionProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override


    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.activity_navigation_drawer_drawer, menu);


        return super.onCreateOptionsMenu(menu);


    }

    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case R.id.nav_share:

                Intent i = new Intent(

                        android.content.Intent.ACTION_SEND);

                i.setType("text/plain");

                i.putExtra(

                        android.content.Intent.EXTRA_TEXT, "My new app https://play.google.com/store/search?q=Turnep");

                startActivity(Intent.createChooser(

                        i,

                        "Share Via"));

                break;

        }

       // Toast.makeText(getApplicationContext(), "You click on menu share", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}
