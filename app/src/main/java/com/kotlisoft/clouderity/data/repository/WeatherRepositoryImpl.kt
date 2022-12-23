package com.kotlisoft.clouderity.data.repository

import com.kotlisoft.clouderity.data.mappers.toWeatherInfo
import com.kotlisoft.clouderity.data.remote.WeatherApi
import com.kotlisoft.clouderity.domain.repository.WeatherRepository
import com.kotlisoft.clouderity.domain.util.Resource
import com.kotlisoft.clouderity.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherData(
        latitude: Double,
        longitude: Double
    ): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(latitude, longitude).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }
}