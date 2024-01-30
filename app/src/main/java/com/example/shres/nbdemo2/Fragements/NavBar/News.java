package com.example.shres.nbdemo2.Fragements.NavBar;


import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.shres.nbdemo2.Activity.AboutandFaq;
import com.example.shres.nbdemo2.Activity.NavigationDrawerActivity;
import com.example.shres.nbdemo2.News_java.Articles_news;
import com.example.shres.nbdemo2.News_java.NewsItems;
import com.example.shres.nbdemo2.News_java.NewsViewAdapter;
import com.example.shres.nbdemo2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;


public class News extends Fragment {
    private static final String TAG = News.class.getSimpleName();
    private ListView mListView;
    private ProgressBar mProgressBar;
    private NewsViewAdapter mListAdapter;
    private ArrayList<NewsItems> mListData;
    private String FEED_URL;
    public static ProgressBar progressBar2;


    public News() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);


        FEED_URL = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=75018a76234946df8975bdac9f556d06";
        mListView = (ListView) view.findViewById(R.id.listView);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressBar2 = (ProgressBar) view.findViewById(R.id.list_item_progressbar);


        //Initialize with empty data
        mListData = new ArrayList<>();
        mListAdapter = new NewsViewAdapter(getActivity(), R.layout.news_model, mListData);
        mListView.setAdapter(mListAdapter);
        Log.i("result", "hello");
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NewsItems item = (NewsItems) parent.getItemAtPosition(position);

                /*Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrl()));*/
                Intent Article = new Intent(getActivity(), Articles_news.class);
                Article.putExtra("Headlines", item.getTitle());
                Article.putExtra("News Image", item.getImage());
                Article.putExtra("discription", item.getDescription());
                Article.putExtra("date", item.getDate());
                Article.putExtra("auther", item.getAuther());
                Article.putExtra("content", item.getContent());

                startActivity(Article);
            }
        });

        //Start download
        new News.AsyncHttpTask().execute(FEED_URL);
        mProgressBar.setVisibility(View.VISIBLE);
        return view;

    }

    public class AsyncHttpTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpsURLConnection urlConnection = null;
            try {
                url = new URL(urls[0]);
                Log.i("result", "hello");
                if (result != null) {
                    String response = streamToString(urlConnection.getInputStream());
                    parseResult(response);
                    return result;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String result) {
            // Download complete. Let us update UI
            if (result != null) {
                mListAdapter.setListData(mListData);
            } else {
                Toast.makeText(getActivity(), "Failed to load data!", Toast.LENGTH_SHORT).show();
            }
            mProgressBar.setVisibility(View.GONE);
        }
    }

    String streamToString(InputStream stream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
        String line;
        String result = "";
        while ((line = bufferedReader.readLine()) != null) {
            result += line;
        }
        // Close stream
        if (null != stream) {
            stream.close();
        }
        return result;
    }

    /**
     * Parsing the feed results and get the list
     *
     * @param result
     */
    public void parseResult(String result) {
        try {
            JSONObject response = new JSONObject(result);
            JSONArray posts = response.optJSONArray("articles");
            NewsItems item;
            for (int i = 0; i < posts.length(); i++) {
                JSONObject post = posts.optJSONObject(i);
                String title = post.optString("title");
                Log.i("Title", title);
                String image = post.optString("urlToImage");
                String description = post.optString("description");
                String date = post.optString("publishedAt");
                String auther = post.optString("author");
                String content = post.optString("content");
                String url = post.optString("url");
                item = new NewsItems();
                item.setTitle(title);
                item.setImage(image);
                item.setUrl(url);
                item.setDescription(description);
                item.setDate(date);
                item.setAuther(auther);
                item.setContent(content);


                mListData.add(item);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
