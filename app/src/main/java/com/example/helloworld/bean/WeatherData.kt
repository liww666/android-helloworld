package com.example.helloworld.bean

class WeatherData(
    var status: Int,
    var result:Result,
    var message :String

) {
    override fun toString(): String {
        return "WeatherData(status=$status, result=$result, message='$message')"
    }
}
