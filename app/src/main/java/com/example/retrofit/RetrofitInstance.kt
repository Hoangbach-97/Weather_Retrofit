package com.example.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
     companion object{
         val interceptor = HttpLoggingInterceptor().apply {
             this.level = HttpLoggingInterceptor.Level.BODY
         }
         val client = OkHttpClient.Builder().apply {
             this.addInterceptor(interceptor)
         }.build()

         val BASE_URL="https://api.weatherapi.com/v1/"
         fun getResult() :Retrofit{
             return Retrofit.Builder().baseUrl(BASE_URL).client(client)
                 .addConverterFactory(GsonConverterFactory.create()).build()
         }
     }
}