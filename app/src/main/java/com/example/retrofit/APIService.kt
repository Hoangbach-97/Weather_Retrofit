package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("current.json")
     fun  currentWeather(@Query("key") apiKey:String, @Query("q") location:String ): Call<Weather>
}