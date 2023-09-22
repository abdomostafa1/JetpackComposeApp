package com.example.myapplication.data

sealed class PickupScreenState {
    object Loading : PickupScreenState()
    data class Error(val message: String) : PickupScreenState()
    data class Success(val pickups: List<PickupRecord>) : PickupScreenState()
}



