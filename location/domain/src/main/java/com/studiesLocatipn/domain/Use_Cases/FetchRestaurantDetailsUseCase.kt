package com.studiesLocatipn.domain.Use_Cases

import com.studiesLocatipn.domain.Repository.LocationRepository
import javax.inject.Inject

class FetchRestaurantDetailsUseCase @Inject constructor(

    private  val locationRepository: LocationRepository
) {


    operator  fun invoke(placeId:String)=locationRepository.fetchPlaces(placeId)
}