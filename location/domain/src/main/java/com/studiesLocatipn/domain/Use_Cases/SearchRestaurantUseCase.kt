package com.studiesLocatipn.domain.Use_Cases

import com.studiesLocatipn.domain.Repository.LocationRepository
import javax.inject.Inject

class SearchRestaurantUseCase @Inject constructor( private  val locationRepository: LocationRepository){

    operator fun invoke(q:String)=locationRepository.searchRestaurants(q)
}