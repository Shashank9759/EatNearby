package com.studiesLocation.data.mappers

import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.model.Place
import com.google.maps.android.PolyUtil
import com.studiesLocation.data.Models.DirectionApiResponse
import com.studiesLocatipn.domain.Model.DirectionDetails
import com.studiesLocatipn.domain.Model.PlaceDetails

fun Place.toDomain():PlaceDetails{
    return PlaceDetails(

        placeId = "",
        name=this.name.orEmpty(),
        destination = this.latLng!!,
        origin=LatLng(0.0,0.0),
        delivery = this.delivery.equals(Place.BooleanPlaceAttributeValue.TRUE),
        rating=this.rating?.toFloat()?:0f)


}
fun DirectionApiResponse.toDomain():DirectionDetails{
    return DirectionDetails(
        points = PolyUtil.decode(this.routes[0].overview_polyline.points),
        distance= this.routes.get(0).legs[0].distance.toString(),
        duration= this.routes.get(0).legs[0].duration.toString(),
        html = this.routes.get(0).legs.get(0).steps.get(0).html_instructions
    )
}