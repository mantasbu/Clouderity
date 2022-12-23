package com.kotlisoft.clouderity.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlisoft.clouderity.domain.location.LocationTracker
import com.kotlisoft.clouderity.domain.repository.WeatherRepository
import com.kotlisoft.clouderity.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
): ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    fun loadWeatherInfo() = viewModelScope.launch {
        state = state.copy(
            isLoading = true,
            error = null
        )
        val currentLocation = locationTracker.getCurrentLocation()
        if (currentLocation != null) {
            when (
                val result = repository
                    .getWeatherData(
                        currentLocation.latitude,
                        currentLocation.longitude
                    )
            ) {
                is Resource.Success -> {
                    state = state.copy(
                        weatherInfo = result.data,
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        weatherInfo = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        } else {
            state = state.copy(
                isLoading = false,
                error = "Couldn't retrieve location. Make sure to grant permission and enable GPS."
            )
        }
    }
}