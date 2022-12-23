package com.kotlisoft.clouderity.data.remote

import com.squareup.moshi.Json

data class DailyWeatherDto(
    @field:Json(name = "time")
    val times: List<String>,

    @field:Json(name = "temperature_2m_min")
    val minTemperatures: List<Double>,

    @field:Json(name = "temperature_2m_max")
    val maxTemperatures: List<Double>,

    @field:Json(name = "weathercode")
    val weatherCodes: List<Int>,

    @field:Json(name = "sunrise")
    val sunrises: List<String>,

    @field:Json(name = "sunset")
    val sunsets: List<String>,

    @field:Json(name = "cloudcover")
    val cloudCovers: List<Int>,

    @field:Json(name = "windspeed_10m_max")
    val maxWindSpeeds: List<Double>
)
