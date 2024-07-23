package com.studiesCommon.utils.Navigation.events_and_results

import android.location.Location

sealed class LocationEvent(val location: Location?=null) {
    class LocationInProgress(location:Location):LocationEvent(location)
    class ReachedDestination():LocationEvent()
    class Idle():LocationEvent()
}