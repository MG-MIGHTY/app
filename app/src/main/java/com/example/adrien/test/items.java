package com.example.adrien.test;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class items {


    @SerializedName("items")
    private ArrayList<Photo> photos;

    public items(){ }

    public ArrayList<Photo> getPhotos(){
        return photos;
    }
}