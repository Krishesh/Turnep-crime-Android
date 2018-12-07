package com.example.shres.nbdemo2.RecyclerView;

public class News_object {

    String name;
    String news_text;
    String Date;

    public News_object() {

    }

    public News_object(String name, String auther, String date) {
        this.name = name;
        this.news_text = auther;
        Date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNews_text() {
        return news_text;
    }

    public void setNews_text(String news_text) {
        this.news_text = news_text;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}


