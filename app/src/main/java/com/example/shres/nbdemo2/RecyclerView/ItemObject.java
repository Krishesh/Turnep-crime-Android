package com.example.shres.nbdemo2.RecyclerView;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemObject implements Parcelable {
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemObject(int image, String name) {
        this.image = image;
        this.name = name;
    }

    private String name;

    protected ItemObject(Parcel in) {
        image = in.readInt();
        name = in.readString();
    }


    public static final Creator<ItemObject> CREATOR = new Creator<ItemObject>() {
        @Override
        public ItemObject createFromParcel(Parcel in) {
            return new ItemObject(in);
        }

        @Override
        public ItemObject[] newArray(int size) {
            return new ItemObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(name);
    }
}
