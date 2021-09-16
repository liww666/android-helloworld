package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.helloworld.bean.WeatherData
import com.example.helloworld.vm.WeatherService
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitActivity : AppCompatActivity() {

    private lateinit var baiduBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        baiduBtn = findViewById(R.id.btn_baidu)
        baiduBtn.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.map.baidu.com/")
                .build()
            var weatherService = retrofit.create(WeatherService::class.java)
            var weatherData = weatherService.getWeatherInfo("now","340123",
                    "json","ddgvw3DhTX0ezFccPp8fDbA5P13leBR2")
            weatherData.enqueue(object:Callback<WeatherData>{
                override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                    var wd = response.body() as WeatherData
                    Toast.makeText(applicationContext,wd.result.now.toString(), Toast.LENGTH_LONG).show()

                }

                override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
//            var resp = weatherData.execute().body()

//
//            println(resp)
//            Toast.makeText(this,resp.body().toString(),Toast.LENGTH_SHORT).show()
        }
    }


}