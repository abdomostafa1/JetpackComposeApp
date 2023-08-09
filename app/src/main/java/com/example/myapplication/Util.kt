package com.example.myapplication

import android.content.Context
import androidx.compose.ui.graphics.Color
import com.example.myapplication.data.OrderStatusENum
import com.example.myapplication.ui.theme.Gray
import com.example.myapplication.ui.theme.Green
import com.example.myapplication.ui.theme.LightRed
import com.example.myapplication.ui.theme.Yellow


fun getStatusName(statusId: Int, context: Context): String {
    var status = ""
    status = when (statusId) {
        1 -> {
            context.getString(R.string.ready_for_delivery)
        }

        2 -> {
            context.getString(R.string.assigned_for_delivery)
        }

        3 -> {
            context.getString(R.string.out_for_delivery)
        }

        4 -> {
            context.getString(R.string.delivered)
        }

        5 -> {
            context.getString(R.string.canceled)
        }

        6 -> {
            context.getString(R.string.ready_for_delivery)
        }

        7 -> {
            context.getString(R.string.assigned_for_pickup)
        }

        8 -> {
            context.getString(R.string.picked_up)
        }

        9 -> {
            context.getString(R.string.at_warehouse)
        }

        10 -> {
            context.getString(R.string.cancelled_pickup)
        }

        11 -> {
            context.getString(R.string.postponed)
        }

        12 -> {
            context.getString(R.string.archive)
        }

        13 -> {
            context.getString(R.string.paid_to_vendor)
        }

        14 -> {
            context.getString(R.string.ready_for_return)
        }

        15 -> {
            context.getString(R.string.assigned_for_return)
        }

        16 -> {
            context.getString(R.string.out_for_return)
        }

        17 -> {
            context.getString(R.string.returned)
        }

        else -> {
            context.getString(R.string.unknown)
        }
    }
    return status
}
fun getCardColor(statusId: Int, hasProblem: Boolean = false): Color {
    when (statusId) {
        OrderStatusENum.DELIVERED.value -> {
            return Green
        }

        OrderStatusENum.PICKED_UP.value -> {
            return Green
        }

        OrderStatusENum.CANCELLED.value -> {
            return LightRed
        }

        OrderStatusENum.CANCELLED_PICKUP.value -> {
            return LightRed
        }

        OrderStatusENum.POSTPONED.value -> {
            return Yellow
        }

        OrderStatusENum.OUT_FOR_DELIVERY.value -> {
            return if (hasProblem) Yellow
            else Gray
        }

        OrderStatusENum.ASSIGNED_FOR_PICK.value -> {
            return Gray
        }

        else -> {
            return Gray
        }
    }

}

fun getTextColor(statusId: Int, hasProblem: Boolean = false): Color {
    return when (statusId) {

        OrderStatusENum.CANCELLED.value -> {
            Color.White
        }

        OrderStatusENum.CANCELLED_PICKUP.value -> {
            Color.White
        }

        else -> {
            Color.Black
        }
    }

}

fun getIconTint(statusId: Int, hasProblem: Boolean = false): Color {
    return when (statusId) {

        OrderStatusENum.CANCELLED.value -> {
            LightRed
        }

        OrderStatusENum.CANCELLED_PICKUP.value -> {
            LightRed
        }

        else -> {
            Color.White
        }
    }

}

fun getIconBackgroundColor(statusId: Int, hasProblem: Boolean = false): Color {
    return when (statusId) {

        OrderStatusENum.CANCELLED.value -> {
            Color.White
        }

        OrderStatusENum.CANCELLED_PICKUP.value -> {
            Color.White
        }

        else -> {
            LightRed
        }
    }

}
