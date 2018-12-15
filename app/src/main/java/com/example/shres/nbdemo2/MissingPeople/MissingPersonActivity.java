package com.example.shres.nbdemo2.MissingPeople;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shres.nbdemo2.R;

public class MissingPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing_person);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Missing People");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);




        TextView mName = findViewById(R.id.missingname);
        TextView mAge = findViewById(R.id.age);
        TextView mDiscription = findViewById(R.id.missing_discription);
        TextView mtitle = findViewById(R.id.missingtitle);
        ImageView mimage = findViewById(R.id.missingimage);

        // get data

        byte[] bytes=getIntent().getByteArrayExtra("image");
        String name = getIntent().getStringExtra("name");
        String age = getIntent().getStringExtra("age");
        String discription = getIntent().getStringExtra("discription");
        String title = getIntent().getStringExtra("title");
        Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);

        //set data to view
        mName.setText("Name-"+name);
        mAge.setText("Age-"+age);
        mDiscription.setText(discription);
        mtitle.setText(title);
        mimage.setImageBitmap( bitmap);



    }

  /*  public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);


    }*/
}
