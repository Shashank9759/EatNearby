package com.studiesLocation.presentation.Screens.places

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studiesCommon.utils.Navigation.events_and_results.PlaceResult
import com.studiesLocatipn.domain.Model.PlaceDetails
import com.studiesLocatipn.domain.Use_Cases.FetchRestaurantDetailsUseCase
import com.studiesLocatipn.domain.Use_Cases.SearchRestaurantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class PlacesSearchViewModel @Inject constructor(private val searchRestaurantUseCase: SearchRestaurantUseCase
,private val fetchRestaurantDetailsUseCase: FetchRestaurantDetailsUseCase)
    :ViewModel(){
        private val _search:MutableState<PlaceResult> = mutableStateOf<PlaceResult>(PlaceResult.Idle())
    val search : State<PlaceResult> get() = _search


    private val _query:MutableStateFlow<String> = MutableStateFlow("")
    val query:StateFlow<String>  get() = _query

    fun updateQuery(q:String){
        _query.value=q
    }
init {
    viewModelScope.launch {
         _query.debounce(1000).collectLatest {
             searchRestaurants(it)
         }
    }
}
    fun searchRestaurants(q:String) = viewModelScope.launch {

        searchRestaurantUseCase(q).collectLatest {
            _search.value=it


     }



    }

    fun fetchDetails(placeId:String,result:(PlaceDetails)->Unit)=viewModelScope.launch{
        fetchRestaurantDetailsUseCase(placeId).collectLatest {

            result.invoke(it)
        }
    }

}