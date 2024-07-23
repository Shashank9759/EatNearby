package com.studiesLocatipn.domain.Model

import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PlaceDetails(

    val placeId:String,
    val name:String,
    val destination:LatLng,
    var origin:LatLng,
    val delivery:Boolean,
    val rating:Float


):Parcelable
