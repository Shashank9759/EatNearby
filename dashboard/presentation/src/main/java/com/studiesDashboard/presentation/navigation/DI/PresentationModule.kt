package com.studiesDashboard.presentation.navigation.DI

import com.studiesDashboard.presentation.navigation.DashboardApi
import com.studiesDashboard.presentation.navigation.DashboardApiImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PresentationModule {

    @Singleton
    @Provides
    fun provideDashboardApi():DashboardApi{
        return DashboardApiImp()
    }
}