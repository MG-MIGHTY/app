package com.example.adrien.test;

import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("title")
    private String name;

    @SerializedName("link")
    private String url;

    public Photo(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}