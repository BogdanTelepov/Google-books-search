package com.bogdan.retrofitexample.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VolumeInfo {

    @SerializedName("title")
    public String title;

    @SerializedName("authors")
    public List<String> authors;

    @SerializedName("averageRating")
    public double averageRating;

    @SerializedName("previewLink")
    public String previewLink;

    @SerializedName("publishedDate")
    public String publishedDate;

    @SerializedName("pageCount")
    public int pageCount;


    @SerializedName("infoLink")

    public String infoLink;

    @SerializedName("imageLinks")
    public ImageLinks imageLinks;


    @SerializedName("canonicalVolumeLink")

    public String canonicalVolumeLink;

    public String getPreviewLink() {
        return previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }
}

