package com.studiesLocation.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.studiesCommon.utils.Navigation.FeatureApi

interface LocationFeatureApi:FeatureApi {
}
class LocationFeatureApiImp:LocationFeatureApi{
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {


        InternalLocationFeatureApi.registerGraph(navHostController,navGraphBuilder)
    }

}