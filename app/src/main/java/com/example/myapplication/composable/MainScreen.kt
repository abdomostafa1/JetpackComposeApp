package com.example.myapplication.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.Light
import com.example.myapplication.ui.theme.LightRed


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun MainScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 8.dp, 16.dp, 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(LightRed, RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            Text(text = "Hello, Ahmed Mohamed!", color = Light, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(48.dp))
            Text(text = "ID:1110", color = Light, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Deliver Shipments",
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 8.dp)
        )

        Text(
            text = "Date: 13/5/2013",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        ShipmentItem()
    }
}