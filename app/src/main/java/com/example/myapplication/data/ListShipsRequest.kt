package com.example.myapplication.data

data class ListShipsRequest(
    var HasCustomerDetailsDTO: Boolean = true,
    var HasCustomerFollowUpDTO: Boolean = false,
    var HasFeesDetailsDTO: Boolean = true,
    var HasFollowUpDTOs: Boolean = false,
    var HasProblemDTOs: Boolean = false,
    var HasSettingDTO: Boolean = false,
    var HasShipItemDTOs: Boolean = false,
    var HasVendorDetailsDTO: Boolean = true,
    var IsDesc: Boolean = true,
    var OrderByColumn: String? = null,
    var PageIndex: Int = 0,
    var PageSize: Int = 0,
    var ShipDTO_Filter: ShipDTOFilter = ShipDTOFilter()
)

data class ShipDTOFilter(
    var DeliveryManId: Int = 3165
)
