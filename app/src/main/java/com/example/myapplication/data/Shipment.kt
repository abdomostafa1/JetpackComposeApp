package com.example.myapplication.data

import java.io.Serializable

data class Shipment(
    val areaId: Int,
    val areaName: String,
    val branchId: Int?,
    val branchName: String,
    val cancelComment: String,
    val cashTransferDTO: Any?,
    val cashTransferId: Any?,
    val createdAt: String,
    val customerDetailsDTO: CustomerDetailsDTO?,
    val customerFollowUpDTO: CustomerFollowUpDTO?,
    val dateFrom: Any?,
    val dateTo: Any?,
    val deliveryManId: Int,
    val deliveryManName: String,
    val description: Any?,
    val feesDetailsDTO: FeesDetailsDTO?,
    val followUpDTOs: List<FollowUpDTO>?,
    val hasPickup: Any?,
    val hasProblem: Boolean,
    val isCashReceived: Boolean,
    val isForReceiveCash: Boolean,
    val isForReceiveReturns: Boolean,
    val isForTransferCash: Boolean,
    val noOfItems: Int,
    val partialItems: Any?,
    val pickupRequestId: Any?,
    val problemDTOs: List<ProblemDTO>?,
    val productIDs: Any?,
    val productsPrice: Any?,
    val productsQuantity: Any?,
    val refId: String?,
    val returnCount: Int,
    val search: Any?,
    val selected: Boolean,
    val settingDTO: SettingDTO?,
    val shipItemDTOs: List<ShipItemDTO>?= null,
    val shipmentIDs: Any?,
    val shipmentId: Int,
    val shipmentServiceId: Int,
    val shipmentServiceName: String,
    val shipmentTypeId: Int,
    val statusDTO: StatusDTOX,
    val statusIDs: Any?,
    val statusId: Int,
    val vendorDetailsDTO: VendorDetailsDTO?,
    val zoneId: Int,
    val zoneName: String,
    var isChecked:Boolean=false
): Serializable

data class CustomerDetailsDTO(
    val apartment: Int?,
    val customerAddress: String?,
    val customerId: Int?,
    val customerName: String?,
    val customerPhone: String?,
    val customerPhone2: String?,
    val floor: Int,
    val landmark: String?,
    val location: String?
)

data class FeesDetailsDTO(
    val cancelFees: Double,
    val isAfford: Any?,
    val packingFees: Double,
    val partialDeliveryFees: Double,
    val shippingFees: Double,
    val shippingFeesPaid: Double,
    val sizeFees: Double,
    val total: Double,
    val vendorCash: Double,
    val weightFees: Double
)

data class VendorDetailsDTO(
    val isPaidToVendor: Boolean,
    val paidToVendorAt: String,
    val vendorId: Int,
    val vendorName: String,
    val vendorPhone: String
)

data class ShipItemDTO(
    val courierQuantityDelivered: Int,
    val courierQuantityReturned: Int,
    val imageUrl: String?,
    val isStcok: Boolean,
    val name: String,
    val price: Double,
    val quantity: Int,
    val shipmentId: Int,
    val shipmentItemId: Int,
    val size: String,
    val statusDTO: StatusDTOX,
    val statusId: Int,
    val vendorProductId: Any?
)

data class SettingDTO(
    val isFragilePackage: Boolean,
    val isOpenPackage: Boolean,
    val isPartialDelivery: Boolean,
    val isStock: Boolean,
    val packingId: Int,
    val packingName: String,
    val packingTypeId: Int,
    val packingTypeName: String,
    val size: String,
    val warehousePackingId: Int,
    val warehousePackingTypeId: Int,
    val warehouseSize: String,
    val warehouseWeight: Int,
    val weight: Int
)


data class StatusDTOX(
    val deliveryManName: String,
    val id: Int,
    val name: String
)

data class ProblemDTO(
    val isCourierProblem: Boolean,
    val isDeleted: Boolean,
    val isReportToVendor: Boolean,
    val isSolved: Boolean,
    val note: String,
    val problemTypeId: Int,
    val problemTypeName: String,
    val shipmentId: Int,
    val shipmentProblemId: Int,
    val solution: Any?
)

data class CustomerFollowUpDTO(
    val callAnswerCount: Int,
    val callNotAnswerCount: Int,
    val isCallAnswered: Any?,
    val isConfirmed: Any?,
    val nextCallOn: Any?,
    val nextCallTimeFrom: Any?,
    val nextCallTimeTo: Any?,
    val note: Any?,
    val shipmentCustomerFollowUpId: Int,
    val shipmentId: Int
)

data class FollowUpDTO(
    val comment: String?,
    val createdAt: String,
    val createdBy: Int,
    val createdByName: String,
    val followUpTypeId: Any?,
    val shipmentId: Any?,
    val statusId: Any?,
    val title: String
)