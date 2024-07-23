package com.studies.eatnearby.DI

import com.studies.eatnearby.navigation.NavigationProvider
import com.studiesDashboard.presentation.navigation.DashboardApi
import com.studiesLocation.presentation.LocationFeatureApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Singleton
    @Provides
    fun provideNavigationProvider( dashboardApi: DashboardApi, locationFeatureApi: LocationFeatureApi):NavigationProvider{
        return NavigationProvider(dashboardApi,locationFeatureApi)
    }
}