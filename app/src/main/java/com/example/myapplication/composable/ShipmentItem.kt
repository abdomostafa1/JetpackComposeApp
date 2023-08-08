package com.example.myapplication.composable

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.LightRed

@Composable
fun ShipmentItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = LightRed)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Shipment", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Customer Name: Mohamed Ali", fontSize = 14.sp, fontWeight = FontWeight.Light)
            Text(text = "Area: Sheikh Zayed", fontSize = 14.sp, fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "COD: 0 of 1050", fontSize = 14.sp, fontWeight = FontWeight.Bold)

        }
    }
}