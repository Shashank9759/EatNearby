package com.studiesLocatipn.domain.DI

import com.studiesLocatipn.domain.Repository.LocationRepository
import com.studiesLocatipn.domain.Use_Cases.FetchRestaurantDetailsUseCase
import com.studiesLocatipn.domain.Use_Cases.GetDirectionUseCase
import com.studiesLocatipn.domain.Use_Cases.SearchRestaurantUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DomainModule {



   @Provides
    fun provideSearchRestaurantUseCase(locationRepository: LocationRepository):SearchRestaurantUseCase{
        return SearchRestaurantUseCase(locationRepository)
    }



    @Provides
    fun provideRestaurantDetailsUseCase(locationRepository: LocationRepository):FetchRestaurantDetailsUseCase{
        return FetchRestaurantDetailsUseCase(locationRepository)
    }


    @Provides
    fun provideDirectionUseCase(locationRepository: LocationRepository):GetDirectionUseCase{
        return GetDirectionUseCase(locationRepository)
    }
}