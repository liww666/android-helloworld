package com.example.helloworld.map

class PositionEntity {
    override fun toString(): String {
        return "PositionEntity{" +
                "latitue=" + latitue +
                ", longitude=" + longitude +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}'
    }

    var latitue = 0.0
    var longitude = 0.0
    var address: String? = null
    var city: String? = null
    fun PositionEntity() {}
    fun PositionEntity(latitude: Double, longtitude: Double, address: String?, city: String?) {
        latitue = latitude
        longitude = longtitude
        this.address = address
        this.city = city
    }
}