package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

data class ListShipsResponse(
    @SerializedName("shipDTOs")
    val ships: List<Shipment>
)
