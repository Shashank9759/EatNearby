package com.studiesLocation.presentation.Screens.places


import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController

import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.maps.model.LatLng
import com.studiesCommon.utils.Navigation.LocationRoute
import com.studiesCommon.utils.Navigation.events_and_results.PlaceResult
import com.studiesLocatipn.domain.Model.PlaceDetails


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RestaurantFinderScreen(navHostController:NavHostController,  viewmodel: PlacesSearchViewModel,goToGoogleMap:(PlaceDetails)->Unit){
val placesresult = viewmodel.search.value
    val query= viewmodel.query.collectAsState()
    val permission= rememberMultiplePermissionsState(permissions = listOf(
        android.Manifest.permission.ACCESS_COARSE_LOCATION,
        android.Manifest.permission.ACCESS_FINE_LOCATION
    ))

if(permission.allPermissionsGranted){
    ConstraintLayout(modifier=Modifier.fillMaxSize()){

        val (searchCons,listCons)= createRefs()
        TextField(value=query.value, onValueChange = {
            viewmodel.updateQuery(it)
        },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(searchCons) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }

        )



        when(placesresult){
            is PlaceResult.Loading->{
                Box(modifier = Modifier.fillMaxSize(), contentAlignment  = Alignment.Center){
                  CircularProgressIndicator()
                }
            }
            is PlaceResult.Success->{

                LazyColumn(modifier = Modifier.constrainAs(listCons){
                    top.linkTo(searchCons.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    height= Dimension.fillToConstraints
                }){
                    items(placesresult.list){

                        Text(
                            text=it.getFullText(null).toString(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                                .clickable {
                                    viewmodel.fetchDetails(it.placeId){


                                     it.origin= LatLng(
                                         placesresult.location?.latitude!!,
                                         placesresult.location?.longitude!!
                                     )

                                       goToGoogleMap.invoke(it)
                                        navHostController.navigate(LocationRoute.GOOGLE_MAPS.route)
                                    }
                                }
                        )

                    }

                }
            }
            is PlaceResult.Idle->{

            }
            is PlaceResult.Error->{
                Box(modifier = Modifier.fillMaxSize(), contentAlignment  = Alignment.Center){
                    Text(text=placesresult.message.toString())
                }
            }
        }



    }
}else{
    LaunchedEffect(key1 = Unit) {
        permission.launchMultiplePermissionRequest()
        
    }
}

}