package com.bogdan.retrofitexample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBody {

    @SerializedName("kind")
    private String kind;
    @SerializedName("totalItems")
    private int totalItems;
    @SerializedName("items")
    List<Book> bookList;
}
