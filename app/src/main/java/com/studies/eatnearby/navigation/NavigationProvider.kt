package com.studies.eatnearby.navigation

import com.studiesDashboard.presentation.navigation.DashboardApi
import com.studiesLocation.presentation.LocationFeatureApi

data class NavigationProvider(
    val dashboardApi: DashboardApi,
    val locationFeatureApi: LocationFeatureApi
)
