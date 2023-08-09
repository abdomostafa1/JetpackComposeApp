package com.example.myapplication.data

enum class ProblemStatusEnum(val value: Int){
    CUSTOMER_PAID_WITH_DIFF_PRICE(3),
    NEW_PROBLEM(4)
}

enum class OrderStatusENum(val value: Int) {
    //FILTER ORDERS LIST
    READY_FOR_DELIVERY(1),
    ASSIGNED_FOR_DELIVERY(2),
    OUT_FOR_DELIVERY(3),
    DELIVERED(4),
    CANCELLED(5),

    READY_FOR_PICK(6),
    ASSIGNED_FOR_PICK(7),
    PICKED_UP(8),
    AT_WAREHOUSE(9),
    CANCELLED_PICKUP(10),
    POSTPONED(11),
    ARCHIVE(12),
    PAID_TO_VENDOR(13),
    READY_FOR_RETURN(14),
    ASSIGNED_FOR_RETURN(15),
    OUT_FOR_RETURN(16),
    RETURNED(17)
}

enum class PickupTypeEnum(val value:Int){
    STOCK_PICKUP(1),
    ITEMS_PICKUP(2)
}


enum class ShipmentType(val value: Int) {
    PICKUP(1),
    FULFILMENT(2),
    RETURN(3),
    STOCK(4),
    CASH_WITH_DRIVER(5)
}
