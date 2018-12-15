package com.example.shres.nbdemo2.News_java;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shres.nbdemo2.R;
import com.github.clans.fab.FloatingActionMenu;
import com.squareup.picasso.Picasso;

import java.io.InputStream;

public class Articles_news extends AppCompatActivity {

    FloatingActionMenu menu;
    FloatingActionButton b1, b2, b3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles_news);

        menu = (FloatingActionMenu) findViewById(R.id.menu);
        menu.setClosedOnTouchOutside(true); /**This method will close the Menu When click on outside**/


        TextView news_headlines = findViewById(R.id.news_headlines);
        TextView Date = findViewById(R.id.date);
        TextView Auther = findViewById(R.id.auther);
        TextView news_disc = findViewById(R.id.news_description);
        TextView News_content = findViewById(R.id.news_content);
        ImageView news_image = findViewById(R.id.news_images_url);

        String news_headlines_title = getIntent().getStringExtra("Headlines");
        news_headlines.setText(news_headlines_title);

        String date = getIntent().getStringExtra("date");
        Date.setText(date);

        String auther = getIntent().getStringExtra("auther");
        Auther.setText(auther);

        String content = getIntent().getStringExtra("content");
        News_content.setText(content);

        String disc = getIntent().getStringExtra("discription");
        news_disc.setText(disc);

        String news_img = getIntent().getStringExtra("News Image");
         new GetImageFromURL(news_image).execute(news_img);

        menu.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
                /**Vibrator Service for Vibration**/
                /**Add a permission in Manifest.xml for vibration**/
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (opened) {
                    /**If menu is opened**/
                    if (vibe != null) {
                        vibe.vibrate(50);
                    }
                } else {
                    /**If menu is closed**/
                    if (vibe != null) {
                        vibe.vibrate(50);
                    }
                }
            }
        });


        b1 = (FloatingActionButton) findViewById(R.id.b1);
        b2 = (FloatingActionButton) findViewById(R.id.b2);
        b3 = (FloatingActionButton) findViewById(R.id.b3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Articles_news.this, "Button 1 is Clicked", Toast.LENGTH_SHORT).show();
                menu.close(true);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Articles_news.this, "Button 2 is Clicked", Toast.LENGTH_SHORT).show();
                menu.close(true);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Articles_news.this, "Button 3 is Clicked", Toast.LENGTH_SHORT).show();
                menu.close(true);
            }
        });


    }

    //Class for download IMAGE
    public class GetImageFromURL extends AsyncTask<String,Void,Bitmap> {
        ImageView imgView;

        public GetImageFromURL(ImageView imgV){
            this.imgView = imgV;
        }

        @Override
        protected Bitmap doInBackground(String... url) {
            String urldisplay = url[0];
            Bitmap bitmap = null;
            try {
                InputStream srt = new java.net.URL(urldisplay).openStream();
                bitmap = BitmapFactory.decodeStream(srt);
            } catch (Exception e){
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgView.setImageBitmap(bitmap);
        }


    }
    public boolean onOptionsItemSelected(MenuItem item) {
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

    }
}
