package com.studiesLocation.presentation

import android.util.Log
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.studiesCommon.utils.Navigation.FeatureApi
import com.studiesCommon.utils.Navigation.LocationRoute
import com.studiesCommon.utils.Navigation.NestedNavigationRoute
import com.studiesLocation.presentation.Screens.googlemaps.GoogleMapScreen
import com.studiesLocation.presentation.Screens.googlemaps.GoogleViewModel

import com.studiesLocation.presentation.Screens.places.PlacesSearchViewModel
import com.studiesLocation.presentation.Screens.places.RestaurantFinderScreen
import com.studiesLocatipn.domain.Model.PlaceDetails
import dagger.hilt.android.lifecycle.HiltViewModel

object InternalLocationFeatureApi:FeatureApi {
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(startDestination = LocationRoute.SEARCH_PLACES.route , route = NestedNavigationRoute.LOCATION.route){
            composable(route=LocationRoute.SEARCH_PLACES.route){
               val viewmodel = hiltViewModel<PlacesSearchViewModel>()
                RestaurantFinderScreen(navHostController,viewmodel){


                   navHostController?.currentBackStackEntry?.savedStateHandle?.set("place",it)

                }

            }


            composable(route=LocationRoute.GOOGLE_MAPS.route){
                 val place= navHostController?.previousBackStackEntry?.savedStateHandle?.get<PlaceDetails>("place")
                place?.let {

                    val viewModel = hiltViewModel<GoogleViewModel>()
                    GoogleMapScreen(navHostController,viewModel,it)
                }


            }
        }
    }
}