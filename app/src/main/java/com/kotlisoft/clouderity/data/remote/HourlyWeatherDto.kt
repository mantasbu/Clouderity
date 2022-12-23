package com.kotlisoft.clouderity.data.remote

import com.squareup.moshi.Json

data class HourlyWeatherDto(
    @field:Json(name = "time")
    val times: List<String>,

    @field:Json(name = "temperature_2m")
    val temperatures: List<Double>,

    @field:Json(name = "relativehumidity_2m")
    val humidities: List<Int>,

    @field:Json(name = "apparent_temperature")
    val apparentTemperatures: List<Double>,

    @field:Json(name = "cloudcover")
    val cloudCovers: List<Int>,

    @field:Json(name = "windspeed_10m")
    val windSpeeds: List<Double>,

    @field:Json(name = "weathercode")
    val weatherCodes: List<Int>
)
