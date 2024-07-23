package com.studiesLocation.presentation.Screens.googlemaps

import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.studiesCommon.utils.Navigation.events_and_results.LocationEvent
import com.studiesCommon.utils.Navigation.events_and_results.UIEvent
import com.studiesLocatipn.domain.Model.DirectionDetails
import com.studiesLocatipn.domain.Use_Cases.GetDirectionUseCase
import com.studiesLocatipn.domain.Use_Cases.GetLocationUpdatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GoogleViewModel @Inject constructor(
    private  val getLocationUpdatesUseCase: GetLocationUpdatesUseCase,
    private val getDirectionUseCase: GetDirectionUseCase
): ViewModel() {



    private  val _currentLocation: MutableStateFlow<LocationEvent> = MutableStateFlow(LocationEvent.Idle())

    val currentLocation:StateFlow<LocationEvent>  get() = _currentLocation


    private  val _routePoints:MutableStateFlow<DirectionDetails> = MutableStateFlow(
        DirectionDetails()
    )

    val routePoints :StateFlow<DirectionDetails>  get() =_routePoints

    fun getDirections(start:LatLng,destination:LatLng,key:String){
        viewModelScope.launch {

              getDirectionUseCase(start,destination,key).collectLatest {
                when(it){
                    is UIEvent.Loading->{}
                    is UIEvent.Error->{}
                    is UIEvent.Success -> {
//                        if(it==null){
//                            Log.d("AAAA","null hai")
//                        }else{
//                            Log.d("AAAA",it.data!!.points.size.toString())
//                        }
                        _routePoints.value=it.data!!
                    }
                }


            }
        }
    }


    fun getLocationUpdates(destination:LatLng){
        viewModelScope.launch {

            getLocationUpdatesUseCase(destination).collectLatest {


            }

        }
    }


}