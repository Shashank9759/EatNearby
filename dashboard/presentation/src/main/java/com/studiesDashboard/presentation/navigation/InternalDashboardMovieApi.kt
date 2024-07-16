package com.studiesDashboard.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.studiesCommon.utils.Navigation.DashboardRoute
import com.studiesCommon.utils.Navigation.FeatureApi
import com.studiesCommon.utils.Navigation.NestedNavigationRoute
import com.studiesDashboard.presentation.navigation.Screens.Home.HomeScreen

object InternalDashboardMovieApi:FeatureApi {
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(startDestination = DashboardRoute.HOME_SCREEN.route,
            route = NestedNavigationRoute.DASHBOARD.route ){

       composable( route= DashboardRoute.HOME_SCREEN.route){
           HomeScreen()
       }



    }

    }
}