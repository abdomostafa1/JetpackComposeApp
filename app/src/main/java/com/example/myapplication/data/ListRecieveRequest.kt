package com.example.myapplication.data

data class ListRecieveRequest(
    val ShipDTO_Filter: ShipDTOFilter = ShipDTOFilter(),
    val IsDesc: Boolean = false,
    val OrderByColumn: String = "",
    val PageSize: Int = 0,
    val PageIndex: Int = 0,
    val HasSettingDTO: Boolean = false,
    val HasCustomerDetailsDTO: Boolean = true,
    val HasVendorDetailsDTO: Boolean = false,
    val HasFeesDetailsDTO: Boolean = false,
    val HasCustomerFollowUpDTO: Boolean = false,
    val HasProblemDTOs: Boolean = false,
    val HasFollowUpDTOs: Boolean = false,
    val HasShipItemDTOs: Boolean = false
)
