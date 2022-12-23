package com.kotlisoft.clouderity.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/forecast?current_weather=true&hourly=temperature_2m,relativehumidity_2m,apparent_temperature,cloudcover,windspeed_10m,weathercode&timezone=auto&daily=temperature_2m_min,temperature_2m_max,weathercode,sunrise,sunset,windspeed_10m_max")
    suspend fun getWeatherData(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): WeatherDto
}