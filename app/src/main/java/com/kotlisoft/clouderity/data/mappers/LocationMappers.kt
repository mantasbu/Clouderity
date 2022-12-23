package com.kotlisoft.clouderity.data.mappers

import android.location.Location
import com.kotlisoft.clouderity.domain.location.CurrentLocation

fun Location.toCurrentLocation(): CurrentLocation {
    return CurrentLocation(
        latitude = latitude,
        longitude = longitude
    )
}