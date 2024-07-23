package com.studiesLocation.presentation.Screens.googlemaps

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState
import com.studiesCommon.utils.Navigation.events_and_results.LocationEvent
import com.studiesLocatipn.domain.Model.PlaceDetails
import kotlinx.coroutines.launch


@Composable
fun GoogleMapScreen(
    navHostController:NavHostController,
    viewmodel:GoogleViewModel,
    place:PlaceDetails
) {


    val currentLocation = viewmodel.currentLocation.collectAsState()
    val route = viewmodel.routePoints.collectAsState()
    val destination =place.destination
    val scope = rememberCoroutineScope()

    when(currentLocation.value){
        is LocationEvent.Idle ->{}
        is LocationEvent.LocationInProgress->{
            currentLocation.value.location?.let {
                location ->

                val cameraPosition= rememberCameraPositionState{
                    position = CameraPosition.builder().zoom(17f).bearing(location.bearing)
                        .tilt(45f).target(
                                LatLng(
                                    location.latitude,
                                    location.longitude
                                )
                        ).build()
                }


              scope.launch {

                  cameraPosition.animate(update=CameraUpdateFactory.newCameraPosition(
                      CameraPosition.builder().zoom(17f).bearing(location.bearing)
                          .tilt(45f).target(
                              LatLng(
                                  location.latitude,
                                  location.longitude
                              )
                          ).build()


                  ),1000)


              }



                LaunchedEffect(key1 = currentLocation.value) {
                    viewmodel.getDirections(

                        start= LatLng(location.latitude,location.longitude),
                        destination= destination,
                        key="AIzaSyCaQfgz_dbGg5GpbVNCEHWy6G9ftWQLjpw"

                    )
                }



                GoogleMap(modifier=Modifier.fillMaxSize(),cameraPositionState=cameraPosition){
                    Polyline(points=route.value.points,color= Color.Blue,width=20f)
                }
            }

        }

        is LocationEvent.ReachedDestination->{

        }
    }

    LaunchedEffect(key1 = Unit, block = {
        viewmodel.getLocationUpdates(destination)


    })

}