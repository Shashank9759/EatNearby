package com.studies.eatnearby.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.studiesCommon.utils.Navigation.NestedNavigationRoute


@Composable
fun MainNavigation(navHostController: NavHostController,navigationProvider: NavigationProvider) {

    NavHost(navController =navHostController , startDestination = NestedNavigationRoute.LOCATION.route){

        navigationProvider.dashboardApi.registerGraph(navHostController,this)
        navigationProvider.locationFeatureApi.registerGraph(navHostController,this)

    }
}