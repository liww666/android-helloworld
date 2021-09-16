package com.example.helloworld.vm

import com.example.helloworld.bean.WeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather/v1/")
     fun getWeatherInfo(@Query(value = "data_type")dataType:String,
                               @Query(value = "district_id")districtId:String,
                               @Query(value = "output")output:String,
                               @Query(value = "ak")ak:String,): Call<WeatherData>
}