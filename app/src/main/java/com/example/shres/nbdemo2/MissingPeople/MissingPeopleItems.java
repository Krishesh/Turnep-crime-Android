package com.example.shres.nbdemo2.MissingPeople;

public class MissingPeopleItems {

    String title,image,discription;

    public MissingPeopleItems(String title, String image, String discription) {
        this.title = title;
        this.image = image;
        this.discription = discription;
    }

    public MissingPeopleItems() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
