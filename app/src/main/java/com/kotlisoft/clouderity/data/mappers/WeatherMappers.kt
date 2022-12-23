package com.kotlisoft.clouderity.data.mappers

import com.kotlisoft.clouderity.data.remote.HourlyWeatherDto
import com.kotlisoft.clouderity.data.remote.WeatherDto
import com.kotlisoft.clouderity.domain.weather.WeatherData
import com.kotlisoft.clouderity.domain.weather.WeatherInfo
import com.kotlisoft.clouderity.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

fun HourlyWeatherDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return times.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val humidity = humidities[index]
        val apparentTemperature = apparentTemperatures[index]
        val cloudCover = cloudCovers[index]
        val windSpeed = windSpeeds[index]
        val weatherCode = weatherCodes[index]
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperature = temperature.roundToInt(),
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode),
                apparentTemperature = apparentTemperature.roundToInt(),
                cloudCovers = cloudCover
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { indexedWeatherData ->
            indexedWeatherData.data
        }
    }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = hourlyWeatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(
       weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}