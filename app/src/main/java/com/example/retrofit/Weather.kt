package com.example.retrofit

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("current")
    val current: CurrentWeather,
) {

}

//{
//    "location": {
//    "name": "Hanoi",
//    "region": "",
//    "country": "Vietnam",
//    "lat": 21.03,
//    "lon": 105.85,
//    "tz_id": "Asia/Bangkok",
//    "localtime_epoch": 1658201866,
//    "localtime": "2022-07-19 10:37"
//},
//    "current": {
//    "temp_c": 29,
//    "is_day": 1,
//    "condition": {},
//    "wind_kph": 11.2,
//    "humidity": 79,
//    "cloud": 100,
//    "uv": 7
//}
//}
