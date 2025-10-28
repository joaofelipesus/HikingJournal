package com.lopes.hikingjournal.models

import com.google.android.gms.maps.model.LatLng

data class Hike(
    val name: String,
    val latitude: Double,
    val longitude: Double
) {
    val coordinate: LatLng
        get() = LatLng(latitude, longitude)
}
