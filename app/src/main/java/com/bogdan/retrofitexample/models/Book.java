package com.bogdan.retrofitexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Book {

    @SerializedName("title")
    private String title;
    @SerializedName("publishedDate")
    private String publishedDate;
    @SerializedName("smallThumbnail")
    private String smallThumbnail;
    @SerializedName("pageCount")
    private int pageCount;
    @SerializedName("averageRating")
    private double averageRating;

    @SerializedName("volumeInfo")
    public VolumeInfo volumeInfo;

    @SerializedName("infoLink")

    public String infoLink;


    public Book(String title, String publishedDate, String smallThumbnail, int pageCount, double averageRating, String infoLink) {
        this.title = title;
        this.publishedDate = publishedDate;
        this.smallThumbnail = smallThumbnail;
        this.pageCount = pageCount;
        this.averageRating = averageRating;

    }

    public String getTitle() {
        return title;
    }


    public String getPublishedDate() {
        return publishedDate;
    }

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public int getPageCount() {
        return pageCount;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public String getInfoLink() {
        return infoLink;
    }
}










