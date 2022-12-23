package com.kotlisoft.clouderity.data.remote

import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "hourly")
    val hourlyWeatherData: HourlyWeatherDto,

    @field:Json(name = "daily")
    val dailyWeatherData: DailyWeatherDto
)
