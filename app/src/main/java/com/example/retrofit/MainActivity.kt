package com.example.retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), Callback<Weather> {
    val API_KEY = "491cf2fbc2e3493aac812404221807"
    val location = "VietNam"
    var listWeather: MutableList<Weather> = mutableListOf()
    lateinit var recyclerView: RecyclerView
    var code: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.list_item_recycle_view)
        recyclerView.adapter = WeatherAdapter(listWeather)
        initData(API_KEY, location)
//        Comment for test push
    }

    fun initData(key: String, location: String) {
        val result = RetrofitInstance.getResult().create(APIService::class.java)
        result.currentWeather(key, location).enqueue(this)
    }

    override fun onResponse(call: Call<Weather>?, response: Response<Weather>?) {
        if (response?.body() == null) {
            return
        }
//        code = response.code()
        listWeather.add(response.body()!!)
//        Toast.makeText(applicationContext, "${listWeather[0].current.humidity}", Toast.LENGTH_LONG).show()
        recyclerView.adapter?.notifyDataSetChanged()
    }

    override fun onFailure(call: Call<Weather>, t: Throwable) {
        Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
    }
}


