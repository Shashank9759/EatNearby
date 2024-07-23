package com.studiesCommon.utils.Navigation.events_and_results

import android.location.Location
import com.google.android.libraries.places.api.model.AutocompletePrediction

sealed class PlaceResult(val location:Location?=null,
                         val list: MutableList<AutocompletePrediction> = mutableListOf(),
                         val message:String?=null) {
    class Success( location:Location,list: MutableList<AutocompletePrediction>):PlaceResult(location,list)
    class Loading():PlaceResult()
    class Idle():PlaceResult()
    class Error(message:String):PlaceResult(message=message)


}