package com.kotlisoft.clouderity.domain.weather

import java.time.LocalDateTime

data class WeatherData(
    val time: LocalDateTime,
    val temperature: Int,
    val humidity: Int,
    val apparentTemperature: Int,
    val cloudCovers: Int,
    val windSpeed: Double,
    val weatherType: WeatherType
)
