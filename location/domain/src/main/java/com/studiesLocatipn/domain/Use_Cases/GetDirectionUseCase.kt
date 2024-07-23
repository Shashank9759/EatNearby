package com.studiesLocatipn.domain.Use_Cases

import com.google.android.gms.maps.model.LatLng
import com.studiesCommon.utils.Navigation.events_and_results.UIEvent
import com.studiesLocatipn.domain.Model.DirectionDetails
import com.studiesLocatipn.domain.Repository.LocationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetDirectionUseCase @Inject constructor(private val locationRepository: LocationRepository) {


    operator fun invoke(start:LatLng,destination:LatLng,key:String)=
        flow<UIEvent<DirectionDetails>> {
            emit(UIEvent.Loading())
            emit(UIEvent.Success(data=locationRepository.getDirection(start,destination,key)))
        }.catch {
            emit(UIEvent.Error(message=it.message.toString()))
        }.flowOn(Dispatchers.IO)
}