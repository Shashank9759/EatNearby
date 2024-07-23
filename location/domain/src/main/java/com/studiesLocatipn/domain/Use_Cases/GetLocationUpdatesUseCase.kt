package com.studiesLocatipn.domain.Use_Cases

import com.google.android.gms.maps.model.LatLng
import com.studiesLocatipn.domain.Repository.LocationRepository
import javax.inject.Inject

class GetLocationUpdatesUseCase @Inject constructor(private  val locationRepository: LocationRepository){

    operator  fun invoke(desination:LatLng)=locationRepository.getLocation(desination)
}