package com.studiesCommon.utils.Navigation

enum class NestedNavigationRoute(val route:String){
    DASHBOARD("dashboard"),
    LOCATION("location")
}

enum class DashboardRoute(val route:String){
    HOME_SCREEN("homescreen")
}
enum class LocationRoute(val route:String){
    SEARCH_PLACES("places"),
    GOOGLE_MAPS("google_maps")

}