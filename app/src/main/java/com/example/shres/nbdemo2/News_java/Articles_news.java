package com.example.shres.nbdemo2.News_java;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shres.nbdemo2.R;
import com.squareup.picasso.Picasso;

import java.io.InputStream;

public class Articles_news extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles_news);

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
       /* news_image.setText(news_headlines_title);*/
       /* Context mContent = null;
        Picasso.with(mContent).load(String.valueOf(news_image)).into(news_image);*/
     new GetImageFromURL(news_image).execute(news_img);






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
}
