package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class WeatherAdapter(weather: List<Weather>) :
    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {
    val mItem: List<Weather> = weather

    lateinit var viewModel: WeatherModel
//    viewModel = ViewModelProvider(this).get(WeatherModel::class.java)


    inner class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var temperature: TextView = itemView.findViewById<TextView>(R.id.temp_c)
        var isDay: TextView = itemView.findViewById<TextView>(R.id.is_day)
        var wind: TextView = itemView.findViewById<TextView>(R.id.wind_kph)
        var humidity: TextView = itemView.findViewById<TextView>(R.id.humidity)
        var cloud: TextView = itemView.findViewById<TextView>(R.id.cloud)
        var cd1:CardView = itemView.findViewById(R.id.cd1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val list = mItem[position]
        holder.temperature.text = "Temperature: "+ list.current.tempC.toString()
        val isDay = list.current.isDay
        checkIsDay(isDay, holder )
        holder.cloud.text ="Cloud "+ list.current.cloud.toString() +" %"
        holder.wind.text ="Wind "+ list.current.windKph.toString() +"km/h"
        holder.humidity.text = "Humidity "+  list.current.humidity.toString() +"%"
    }

    override fun getItemCount(): Int = mItem.size

    fun checkIsDay(isDay:Int, holder: WeatherViewHolder){
        var displayText  = ""
        if (isDay == 1){
            holder.isDay.text = "Day"
            holder.cd1.setBackgroundResource(R.color.purple_200)
        } else {
            holder.isDay.text = "Night"
            holder.cd1.setBackgroundColor(0xFF00AF00.toInt())
        }

    }

}