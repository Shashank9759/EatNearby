package com.studiesLocatipn.domain.Repository

import android.location.Location
import com.google.android.gms.maps.model.LatLng
import com.studiesCommon.utils.Navigation.events_and_results.LocationEvent
import com.studiesCommon.utils.Navigation.events_and_results.PlaceResult
import com.studiesLocatipn.domain.Model.DirectionDetails
import com.studiesLocatipn.domain.Model.PlaceDetails
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun getLocationOnce(location:(Location)->Unit)
    fun searchRestaurants(q:String): Flow<PlaceResult>
    fun fetchPlaces(placeId:String):Flow<PlaceDetails>
  fun getLocation(destination: LatLng):Flow<LocationEvent>

    suspend fun getDirection(start:LatLng,destination:LatLng,key:String): DirectionDetails
}