package com.example.myapplication.composable

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.data.PickupRecord
import com.example.myapplication.data.PickupTypeEnum
import com.example.myapplication.getIconBackgroundColor
import com.example.myapplication.getIconTint
import com.example.myapplication.getStatusName
import com.example.myapplication.getTextColor
import com.example.myapplication.ui.theme.Gray
import com.example.myapplication.ui.theme.LightRed

@Composable
fun PickupItem(
    pickupRecord: PickupRecord,
    cardColor: CardColors,
    context: Context,
    onClickLocation: (String) -> Unit,
    onClickCall: (String) -> Unit,
    onClickEmail: (String) -> Unit,
    onClickDocument: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = cardColor
    ) {
        val pickupType =
            if (pickupRecord.pickupRequestTypeId == PickupTypeEnum.ITEMS_PICKUP.value) "Delivery Pickup"
            else "Stock Pickup"
        val textColor = getTextColor(pickupRecord.statusId, false)
        val iconTint = getIconTint(pickupRecord.statusId, false)
        val iconBackgroundColor = getIconBackgroundColor(pickupRecord.statusId, false)
        val status = getStatusName(pickupRecord.statusId, context)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp)
        ) {
            Row {
                BoldText(text = pickupType, textColor = textColor)
                SpacerHorizontal64()
                BoldText(text = pickupRecord.refId, textColor = textColor)
            }

            NormalText(
                text = "${context.getString(R.string.vendor_name)}: ${pickupRecord.vendorName}",
                textColor = textColor
            )

            Row {
                SmallText(
                    text = "${context.getString(R.string.area)}: ${pickupRecord.vendorAddress}",
                    textColor = textColor
                )
                SpacerHorizontal64()
                SmallText(
                    text = "${context.getString(R.string.status)}: $status",
                    textColor = textColor
                )

            }
            SpacerVertical8()
            Row {
                SmallText(
                    text = "${context.getString(R.string.deliver_to_warehouse)}: ${pickupRecord.areaName}",
                    textColor = textColor
                )
                SpacerHorizontal16()
                Icon(
                    painter = painterResource(id = R.drawable.baseline_document_scanner_24),
                    iconTint = iconTint,
                    modifier = Modifier
                        .background(iconBackgroundColor)
                        .clickable { onClickDocument("Document") }
                )

                SpacerHorizontal8()
                Icon(
                    painter = painterResource(id = R.drawable.baseline_call_24),
                    iconTint = iconTint,
                    modifier = Modifier
                        .background(iconBackgroundColor)
                        .clickable { onClickCall(pickupRecord.vendorPhone) }
                )
                SpacerHorizontal8()
                Icon(
                    painter = painterResource(id = R.drawable.baseline_location_on_24),
                    iconTint = iconTint,
                    modifier = Modifier
                        .background(iconBackgroundColor)
                        .clickable { onClickLocation(pickupRecord.vendorLocation.toString()) }
                )
                SpacerHorizontal8()
                Icon(
                    painter = painterResource(id = R.drawable.baseline_email_24),
                    iconTint = iconTint,
                    modifier = Modifier
                        .background(iconBackgroundColor)
                        .clickable { onClickEmail(pickupRecord.vendorPhone) }
                )

            }

        }
    }

}