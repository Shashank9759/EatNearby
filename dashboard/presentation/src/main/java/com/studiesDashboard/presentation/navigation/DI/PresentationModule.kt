package com.studiesDashboard.presentation.navigation.DI

import com.studiesDashboard.presentation.navigation.DashboardApi
import com.studiesDashboard.presentation.navigation.DashboardApiImp
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class PresentationModule {

    fun provideDashboardApi():DashboardApi{
        return DashboardApiImp()
    }
}