package com.example.myapplication.composable

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.PickupRecord
import com.example.myapplication.ui.theme.LightRed
import com.example.myapplication.viewmodel.PickupViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.getCardColor

@Composable
fun PickupScreen(
    context: Context,
    onClickLocation: (String) -> Unit,
    onClickCall: (String) -> Unit,
    onClickEmail: (String) -> Unit,
    onClickDocument: (String) -> Unit
) {
    val pickupViewModel: PickupViewModel = viewModel()
    val state by pickupViewModel.pickupsResponse.collectAsState()
    pickupViewModel.fetchListPickups()
    PickupContent(
        pickups = state,
        context = context,
        onClickLocation = onClickLocation,
        onClickCall = onClickCall,
        onClickEmail = onClickEmail,
        onClickDocument = onClickDocument
    )
}

@Composable
private fun PickupContent(
    pickups: List<PickupRecord>,
    context: Context,
    onClickLocation: (String) -> Unit,
    onClickCall: (String) -> Unit,
    onClickEmail: (String) -> Unit,
    onClickDocument: (String) -> Unit
) {
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
            Text(text = "Hello, Ahmed Mohamed!", color = Color.White, fontWeight = FontWeight.Bold, maxLines = 1)
            Spacer(modifier = Modifier.width(48.dp))
            Text(text = "ID:1110", color = Color.White, fontWeight = FontWeight.Bold, maxLines = 1)
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

        LazyColumn {
            items(pickups) { item: PickupRecord ->
                val cardColor = getCardColor(item.statusId)
                PickupItem(
                    pickupRecord = item,
                    cardColor = CardDefaults.cardColors(cardColor),
                    context = context,
                    onClickLocation = onClickLocation,
                    onClickCall = onClickCall,
                    onClickEmail = onClickEmail,
                    onClickDocument = onClickDocument
                )
            }
        }
    }
}