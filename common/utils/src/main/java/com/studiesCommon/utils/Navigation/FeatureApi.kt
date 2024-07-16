package com.studiesCommon.utils.Navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface FeatureApi {
    fun registerGraph(navHostController:NavHostController,navGraphBuilder:NavGraphBuilder)
}