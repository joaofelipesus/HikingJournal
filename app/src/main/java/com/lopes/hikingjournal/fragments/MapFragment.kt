package com.lopes.hikingjournal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import dev.hotwire.navigation.fragments.HotwireFragment
import com.lopes.hikingjournal.R
import dev.hotwire.navigation.destinations.HotwireDestinationDeepLink
import com.google.maps.android.compose.GoogleMap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType

@HotwireDestinationDeepLink(uri = "hotwire://fragment/map")
class MapFragment : HotwireFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        view.findViewById<ComposeView>(R.id.compose_view).apply {
            setContent {
                MapView()
            }
        }

        return view
    }

    @Composable
    fun MapView() {
        val coordinate = LatLng(45.511881, -122.595706)
        val markerState = rememberMarkerState(position = coordinate)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(coordinate, 15f)
        }
        GoogleMap(
            cameraPositionState = cameraPositionState,
            properties = MapProperties(mapType = MapType.HYBRID)
        ) {
            Marker(
                state = markerState,
                title = "Mount Tabor"
            )
        }
    }
}