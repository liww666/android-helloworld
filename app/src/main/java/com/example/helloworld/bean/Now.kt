package com.example.helloworld.bean

data class Now(
    var text: String,
    var temp: Int,
    var feels_like: Int,
    var rh: Int,
    var wind_class: String,
    var wind_dir: String,
    var uptime: String
)
