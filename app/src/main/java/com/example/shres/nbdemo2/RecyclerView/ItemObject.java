package com.example.shres.nbdemo2.RecyclerView;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemObject  {
    String id;
    String name;
    String news;
    String Date;
    String imgurl;

    public ItemObject(String name, String news, String date, String imgurl) {
        this.name = name;
        this.news = news;
        Date = date;
        this.imgurl = imgurl;
    }


    public ItemObject() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
