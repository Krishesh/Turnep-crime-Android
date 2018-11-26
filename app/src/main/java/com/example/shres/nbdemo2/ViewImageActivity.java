package com.example.shres.nbdemo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ViewImageActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_image);

        // get intent data
        Intent i = getIntent();

      /*  // Selected image id
        int position = i.getExtras().getInt("id");
        FirebaseHelper helper;
        GridViewAdaptor adapter = new GridViewAdaptor(this, helper.retrieve());
*/
        ImageView imageView = (ImageView) findViewById(R.id.displayImage);
       /* imageView.setImageResource(adapter.mThumbIds[position]);*/
    }

}
