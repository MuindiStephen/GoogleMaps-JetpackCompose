package com.steve_md.googlemapscompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapsScreenUi() {

    // declaring location
    val location = LatLng(0.6128399,34.5195933)
    val cameraPositionState =  rememberCameraPositionState {
        position =  CameraPosition.fromLatLngZoom(location, 16f)
    }
    
    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap (
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ){
            Marker(
                state = MarkerState(position = location),
                title = "You are currently here!",
                snippet = "Marker in current location"
            )
        }
    }
}