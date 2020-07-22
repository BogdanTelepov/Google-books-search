package com.bogdan.retrofitexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBody {

    @SerializedName("kind")
    @Expose
    public String kind;
    @SerializedName("totalItems")
    @Expose
    public Integer totalItems;
    @SerializedName("items")
    @Expose
    public List<Book> bookList = null;
}
