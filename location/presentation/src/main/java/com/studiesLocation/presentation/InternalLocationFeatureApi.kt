package com.studiesLocation.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.studiesCommon.utils.Navigation.FeatureApi
import com.studiesCommon.utils.Navigation.LocationRoute
import com.studiesCommon.utils.Navigation.NestedNavigationRoute
import com.studiesLocation.presentation.Screens.googlemaps.RestaurantFinderScreen
import com.studiesLocation.presentation.Screens.places.PlaceSearch

object InternalLocationFeatureApi:FeatureApi {
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(startDestination = LocationRoute.SEARCH_PLACES.route , route = NestedNavigationRoute.LOCATION.route){
            composable(route=LocationRoute.SEARCH_PLACES.route){

                PlaceSearch()

            }


            composable(route=LocationRoute.GOOGLE_MAPS.route){

                RestaurantFinderScreen()

            }
        }
    }
}