package com.studiesLocation.data.Models

data class Step(
    val distance: Distance,
    val duration: Duration,
    val end_location: EndLocation,
    val html_instructions: String,
    val polyline: Polyline,
    val start_location: StartLocation,
    val travel_mode: String
)