package com.example.retrofit

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    @SerializedName("temp_c")
    val tempC: Double,
    @SerializedName("is_day")
    val isDay: Int,
    @SerializedName("wind_kph")
    val windKph: Double,
    val humidity: Int,
    val cloud: Int,
    val uv: Double
)
