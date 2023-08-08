package com.example.myapplication.data

data class ListPickupsRequest(
    var pickupDTO: PickupDTO = PickupDTO(),
    var hasPickupItemDTO: Boolean = true
)

data class PickupDTO(
    var DeliveryManId: Int = 3165
)