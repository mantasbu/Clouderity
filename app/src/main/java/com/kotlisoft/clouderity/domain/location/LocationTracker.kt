package com.kotlisoft.clouderity.domain.location

interface LocationTracker {
    suspend fun getCurrentLocation(): CurrentLocation?
}