package com.example.shres.nbdemo2.MissingPeople;

public class MissingPeopleItems {

    String title,image,name,discription,age;

    public MissingPeopleItems(String title, String image, String name, String discription, String age) {
        this.title = title;
        this.image = image;
        this.name = name;
        this.discription = discription;
        this.age = age;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
