package com.studiesLocation.data.DI

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient
import com.studiesLocation.data.Respository.LocationRepositoryImpl
import com.studiesLocation.data.data_sourcenetwork.LocationService
import com.studiesLocatipn.domain.Repository.LocationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Qualifier
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DataModule {


    @Singleton
    @Provides
    fun provideFusedLocationProviderClient(@ApplicationContext context: Context):FusedLocationProviderClient{
        return LocationServices.getFusedLocationProviderClient(context)
    }

    @Singleton
    @Provides
    fun providePlacesClient(@ApplicationContext context :Context):PlacesClient{
        Places.initialize(context,"AIzaSyCaQfgz_dbGg5GpbVNCEHWy6G9ftWQLjpw")

      return Places.createClient(context)
    }


    @Singleton
    @Provides
    fun provideLocationRepo(
        fusedLocationProviderClent:FusedLocationProviderClient,
        placesClient: PlacesClient,
        locationService: LocationService
    ):LocationRepository{
        return LocationRepositoryImpl(fusedLocationProviderClent,placesClient,locationService)
    }


    @Provides
    @Singleton
    @LocationRetrofit
    fun provideLocationRetrofit(@DirectionApiBaseUrl s: String):Retrofit{
        return Retrofit.Builder().baseUrl(s).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun provideLocationService(  @LocationRetrofit retrofit: Retrofit): LocationService {
        return retrofit.create(LocationService::class.java)
    }



    @DirectionApiBaseUrl
    @Provides
    fun provideDirectionApiBaseUrl():String{
        return "https://maps.googleapis.com/"
    }


    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DirectionApiBaseUrl




    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocationRetrofit




}