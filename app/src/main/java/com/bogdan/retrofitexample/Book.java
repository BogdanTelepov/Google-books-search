package com.bogdan.retrofitexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Book {

    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("authors")
    @Expose
    public List<String> authors = null;

    @SerializedName("publishedDate")
    @Expose
    public String publishedDate;


    @SerializedName("pageCount")
    @Expose
    public Integer pageCount;

    @SerializedName("imageLinks")
    @Expose
    public ImageLinks imageLinks;


    @SerializedName("infoLink")
    @Expose
    public String infoLink;

    @SerializedName("averageRating")
    @Expose
    public Integer averageRating;

    public Book(String title, List<String> authors, String publishedDate, Integer pageCount, ImageLinks imageLinks, Integer averageRating) {
        this.title = title;
        this.authors = authors;
        this.publishedDate = publishedDate;
        this.pageCount = pageCount;
        this.imageLinks = imageLinks;
        this.averageRating = averageRating;
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

    public Integer getPageCount() {
        return pageCount;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public Integer getAverageRating() {
        return averageRating;
    }

    static class ImageLinks {

        @SerializedName("smallThumbnail")
        @Expose
        public String smallThumbnail;
        @SerializedName("thumbnail")
        @Expose
        public String thumbnail;

        public String getSmallThumbnail() {
            return smallThumbnail;
        }

        public String getThumbnail() {
            return thumbnail;
        }
    }
}









