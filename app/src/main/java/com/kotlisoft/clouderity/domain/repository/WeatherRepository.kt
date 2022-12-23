package com.kotlisoft.clouderity.domain.repository

import com.kotlisoft.clouderity.domain.util.Resource
import com.kotlisoft.clouderity.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(
        latitude: Double,
        longitude: Double
    ): Resource<WeatherInfo>
}