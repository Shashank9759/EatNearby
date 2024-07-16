package com.studiesDashboard.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.studiesCommon.utils.Navigation.FeatureApi

interface DashboardApi : FeatureApi {
}
class DashboardApiImp:DashboardApi{
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        InternalDashboardMovieApi.registerGraph(navHostController,navGraphBuilder)
    }

}