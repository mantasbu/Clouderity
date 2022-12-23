package com.kotlisoft.clouderity.presentation

import com.kotlisoft.clouderity.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
