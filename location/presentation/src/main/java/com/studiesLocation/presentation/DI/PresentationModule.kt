package com.studiesLocation.presentation.DI

import com.studiesLocation.presentation.LocationFeatureApi
import com.studiesLocation.presentation.LocationFeatureApiImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object PresentationModule {

    @Provides
    fun providesLocationFeatureApi():LocationFeatureApi{
       return LocationFeatureApiImp()

    }
}