package com.example.adrien.test;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface APIService {

    @GET("v1")
    Call<items> getItems(@Query("q") String q,@Query("key") String key, @Query("cx") String cx, @Query("searchType") String searchType, @Query("alt") String alt);

}