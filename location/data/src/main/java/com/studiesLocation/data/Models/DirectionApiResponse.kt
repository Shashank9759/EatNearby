package com.studiesLocation.data.Models

data class DirectionApiResponse(
    val geocoded_waypoints: List<GeocodedWaypoint>,
    val routes: List<Route>,
    val status: String
)