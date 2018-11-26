package com.example.shres.nbdemo2.Activity;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shres.nbdemo2.FirebaseHelper;
import com.example.shres.nbdemo2.Fragements.NavBar.CrimeReport;
import com.example.shres.nbdemo2.Fragements.BottomNavBar.Dashboard;
import com.example.shres.nbdemo2.Fragements.BottomNavBar.Home;
import com.example.shres.nbdemo2.Fragements.NavBar.MissingPeople;
import com.example.shres.nbdemo2.Fragements.NavBar.NearBy;
import com.example.shres.nbdemo2.Fragements.NavBar.News;
import com.example.shres.nbdemo2.Fragements.BottomNavBar.Profile;
import com.example.shres.nbdemo2.GridViewAdaptor;
import com.example.shres.nbdemo2.R;
import com.example.shres.nbdemo2.Spacecraft;
import com.example.shres.nbdemo2.ViewImageActivity;
import com.google.firebase.database.DatabaseReference;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;
    private FloatingActionButton fab;
    EditText nameEditTxt,addressEditText,phonenumber;
    DatabaseReference db;
    FirebaseHelper helper;
    private ArrayAdapter<String> adapter;
    //Bottom navigation bar activity  for calling corresponding fragments
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.flMain,new Home());
                    ft.commit();
                    return true;
                case R.id.navigation_dashboard:
                    FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                    ft1.replace(R.id.flMain,new Dashboard());
                    ft1.commit();
                    return true;
                case R.id.navigation_profile:
                    FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                    ft2.replace(R.id.flMain,new Profile());
                    ft2.commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        //call 100
/*
        fab = (FloatingActionButton) findViewById(R.id.call100);
        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override

            public void onClick(View view) {
                // to make call
                Intent callintent = new Intent(Intent.ACTION_DIAL);
                callintent.setData(Uri.parse("tel:100"));
                startActivity(callintent);
            }

        });
*/



        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //default fragment
        if (savedInstanceState == null ){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flMain,new Home());
        ft.commit();

        }
        
      /*  fab=findViewById(R.id.call100);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInputDialog();
            }



        });*/


    }
   /* private void displayInputDialog()
    {
        Dialog d=new Dialog(NavigationDrawerActivity.this);
        d.setTitle("Save To Firebase");
        d.setContentView(R.layout.input_dialog);

        nameEditTxt= (EditText) d.findViewById(R.id.nameEditText);
        addressEditText= (EditText) d.findViewById(R.id.propellantEditText);
        phonenumber= (EditText) d.findViewById(R.id.descEditText);
        Button saveBtn= (Button) d.findViewById(R.id.saveBtn);

        //SAVE
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //GET DATA
                String name=nameEditTxt.getText().toString();
                String address=addressEditText.getText().toString();
                String phone=phonenumber.getText().toString();

                //SET DATA
                Spacecraft s=new Spacecraft();
                s.setName(name);
                s.setAddress(address);
                s.setPhonenumber(phone);

                //SIMPLE VALIDATION
                if(name != null && name.length()>0)
                {
                    //THEN SAVE
                    if(helper.save(s))
                    {
                        //IF SAVED CLEAR EDITXT
                        nameEditTxt.setText("");
                        addressEditText.setText("");
                        phonenumber.setText("");



                    }
                }else
                {
                    Toast.makeText(NavigationDrawerActivity.this,"Name Must Not Be Empty", Toast.LENGTH_SHORT).show();
                }

            }
        });

        d.show();
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // selecting navigation bar items n opening corresponding fragments
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_news) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain,new News());
            ft.commit();
        } else if (id == R.id.nav_missing) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain,new MissingPeople());
            ft.commit();
        } else if (id == R.id.nav_crime_report) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain,new CrimeReport());
            ft.commit();
        } else if (id == R.id.nav_near_by) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain,new NearBy());
            ft.commit();
        } else if (id == R.id.nav_about_FAQ) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
