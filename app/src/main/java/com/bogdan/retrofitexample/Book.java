package com.bogdan.retrofitexample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Book {

    @SerializedName("title")
    private String title;
    @SerializedName("authors")
    private List<String> authors;
    @SerializedName("publishedDate")
    private String publishedDate;
    @SerializedName("smallThumbnail")
    private String smallThumbnail;
    @SerializedName("pageCount")
    private String pageCount;
    @SerializedName("averageRating")
    private String averageRating;
    @SerializedName("infoLink")
    private String infoLink;

    public Book(String title, List<String> authors, String publishedDate, String smallThumbnail, String pageCount, String averageRating, String infoLink) {
        this.title = title;
        this.authors = authors;
        this.publishedDate = publishedDate;
        this.smallThumbnail = smallThumbnail;
        this.pageCount = pageCount;
        this.averageRating = averageRating;
        this.infoLink = infoLink;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public String getPageCount() {
        return pageCount;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public String getInfoLink() {
        return infoLink;
    }
}

