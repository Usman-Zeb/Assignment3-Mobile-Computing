package com.example.assignment3;



import com.example.assignment3.models.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonAPI {
    @GET("api/")
    Call<Results> getPosts(@Query("results") int id);
}
