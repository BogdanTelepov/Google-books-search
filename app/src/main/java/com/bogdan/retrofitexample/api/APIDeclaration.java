package com.bogdan.retrofitexample.api;

import com.bogdan.retrofitexample.models.ResponseBody;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIDeclaration {

    @GET("volumes")
    Call<ResponseBody> getBooks(
            @Query("langRestrict") String langRestrict,
            @Query("maxResults") int maxResults,
            @Query("printType") String printType,
            @Query("key") String key,
            @Query("q") String q);
}
