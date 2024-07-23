package com.studiesLocation.data.Respository;

import android.location.Location
import android.util.Log
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.LocationRestriction
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.model.RectangularBounds
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient
import com.studiesCommon.utils.Navigation.events_and_results.LocationEvent
import com.studiesCommon.utils.Navigation.events_and_results.PlaceResult
import com.studiesLocation.data.data_sourcenetwork.LocationService
import com.studiesLocation.data.mappers.toDomain
import com.studiesLocatipn.domain.Model.DirectionDetails
import com.studiesLocatipn.domain.Model.PlaceDetails
import com.studiesLocatipn.domain.Repository.LocationRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
@Suppress("MissingPermission")
class LocationRepositoryImpl @Inject constructor(private val fusedLocationProviderClient: FusedLocationProviderClient
, private val placesClient: PlacesClient,
    private  val locationService: LocationService): LocationRepository {
    private val  token =AutocompleteSessionToken.newInstance()
    private var currentLocation:LatLng=LatLng(0.0,0.0)
    override fun getLocationOnce(location: (Location) -> Unit) {
        val locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY,100).
                setMaxUpdates(1).build()
        val locationCallback = object : LocationCallback(){
            override fun onLocationResult(p0: LocationResult) {
                p0.locations.get(0)?.let {
                     currentLocation= LatLng(it.latitude,it.longitude)
                    location.invoke(it)
                }
            }

        }

        fusedLocationProviderClient.requestLocationUpdates(locationRequest,locationCallback,null)
    }

    override fun searchRestaurants(q: String): Flow<PlaceResult> = callbackFlow{
       getLocationOnce {location->
           val locationRestriction= findLocationRestriction(location)
           val request= FindAutocompletePredictionsRequest.builder()
               .setSessionToken(token)
               .setCountries("IN")
               .setQuery(q)
               .setTypesFilter(mutableListOf("restaurant"))
               .setLocationRestriction(locationRestriction)
               .build()
           placesClient.findAutocompletePredictions(request).addOnSuccessListener {
              trySend(PlaceResult.Success(location,it.autocompletePredictions))
           }.addOnFailureListener{
               trySend(PlaceResult.Error(it.message.toString()))
           }

       }
        awaitClose {  }
    }

    override fun fetchPlaces(placeId: String): Flow<PlaceDetails>  = callbackFlow {
        val placesList= listOf(
            Place.Field.DELIVERY,
            Place.Field.LAT_LNG,
            Place.Field.ADDRESS,
            Place.Field.PHONE_NUMBER
        )
        val request= FetchPlaceRequest.builder(placeId,placesList).build()
        placesClient.fetchPlace(request).addOnSuccessListener {
            Log.d("AAAA",placeId)
           trySend( it.place.toDomain())
        }
        awaitClose { /* No cleanup required here */ }
    }

    override fun getLocation(destination: LatLng): Flow<LocationEvent>  = callbackFlow{



        val locationRequest=LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY,100)
            .setIntervalMillis(5000)
            .build()
        val locationCallback = object :LocationCallback(){
            override fun onLocationResult(locationResult: LocationResult) {
                currentLocation=LatLng(

                    locationResult.locations.get(0).latitude,
                    locationResult.locations.get(0).longitude
                )

                if(isReachedToTheDestination(currentLocation,destination)){
                    trySend(
                        LocationEvent.ReachedDestination()
                    )
                }else{
                    trySend(
                        LocationEvent.LocationInProgress(locationResult.locations.get(0))
                    )
                }

            }

        }


        fusedLocationProviderClient.requestLocationUpdates(

            locationRequest,
            locationCallback,
            null
        )

        awaitClose {

            fusedLocationProviderClient.removeLocationUpdates(locationCallback)
        }
    }




    private fun isReachedToTheDestination(origin: LatLng,destination: LatLng):Boolean{

        val array = FloatArray(1)
        Location.distanceBetween(
            origin.latitude,
            origin.longitude,
            destination.latitude,
            destination.longitude,
            array
        )

        return array.get(0)<=5f
    }
    override suspend fun getDirection(
        start: LatLng,
        destination: LatLng,
        key: String
    ): DirectionDetails {
      val startLatLng ="${start.latitude},${start.longitude}"
        val destinationLatLng ="${destination.latitude},${destination.longitude}"

       val response= locationService.getDirection(startLatLng,destinationLatLng,key)
        return response.toDomain()
    }

    private fun findLocationRestriction(location: Location): LocationRestriction? {
        return RectangularBounds.newInstance(
            LatLng(location.latitude-0.9,location.longitude-0.9),
            LatLng(location.latitude+0.9,location.longitude+0.9)
        )
    }
}
