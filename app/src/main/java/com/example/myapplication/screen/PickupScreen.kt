package com.example.myapplication.screen

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import com.example.myapplication.NavDestination
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication.data.PickupRecord
import com.example.myapplication.ui.theme.LightRed
import com.example.myapplication.viewmodel.PickupViewModel
import androidx.navigation.NavController
import com.example.myapplication.composable.BoldText
import com.example.myapplication.composable.PickupItem
import com.example.myapplication.data.PickupScreenState
import com.example.myapplication.getCardColor

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PickupScreen(
    navController: NavController,
    context: Context,
    pickupViewModel: PickupViewModel,
    onClickLocation: (String) -> Unit,
    onClickCall: (String) -> Unit,
    onClickEmail: (String) -> Unit,
    onClickDocument: (String) -> Unit
) {
    val state by pickupViewModel.pickupScreenState.collectAsState()


    if (("plpl"=="okkookok") and ("kskk"=="ssjjk")) {
        // Do something if the current user is an Admin, or the target user is active
    }
    mapOf(
        Pair("name", "Ahmed"),
        Pair("age", 24),
        "city" to "Gize"
    )

    val color = 0x123456
    val red = (color xor  0xff0000) shr 16

    AnimatedContent(
        targetState = state,
        label = "",
        transitionSpec = {
            expandHorizontally(animationSpec = tween(2000)) togetherWith shrinkHorizontally(
                animationSpec = tween(
                    1000
                )
            )
        }
    ) {

        when (it) {
            is PickupScreenState.Loading -> {
                ShowLoadingComposable()
            }

            is PickupScreenState.Success -> {
                PickupContent(
                    pickups = (state as PickupScreenState.Success).pickups,
                    context = context,
                    onClickLocation = onClickLocation,
                    onClickCall = onClickCall,
                    onClickEmail = onClickEmail,
                    onClickDocument = onClickDocument,
                    onClickPickupCard = { id -> navController.navigate("PickupDetailsScreen/$id") },
                    onClickGo = { navController.navigate(NavDestination.pickupDetailsScreen) }
                )
            }

            else -> {
                ShowErrorComposable()
            }
        }
    }

}

@Composable
private fun ShowLoadingComposable() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val loader = createRef()
        CircularProgressIndicator(modifier = Modifier.constrainAs(loader) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
    }
}

@Composable
private fun ShowErrorComposable() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val loader = createRef()
        BoldText(text = "Error", modifier = Modifier.constrainAs(loader) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
    }
}


fun callAgain() {
    Log.e("TAG", "callAgain: ")
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PickupContent(
    pickups: List<PickupRecord>,
    context: Context,
    onClickLocation: (String) -> Unit,
    onClickCall: (String) -> Unit,
    onClickEmail: (String) -> Unit,
    onClickDocument: (String) -> Unit,
    onClickPickupCard: (Int) -> Unit,
    onClickGo: () -> Unit
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
            Text(
                text = "Hello, Ahmed Mohamed!",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
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
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 8.dp)
        ) {

            items(items = pickups, key = { item -> item.pickupRequestId }) { item: PickupRecord ->

                val cardColor = getCardColor(item.statusId)
                PickupItem(pickupRecord = item,
                    cardColor = CardDefaults.cardColors(cardColor),
                    context = context,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onClickPickupCard(item.pickupRequestId) }
                        .animateItemPlacement(),
                    onClickLocation = onClickLocation,
                    onClickCall = onClickCall,
                    onClickEmail = onClickEmail,
                    onClickDocument = onClickDocument)

            }

        }
    }

//        LazyColumn(
//            contentPadding = PaddingValues(bottom = 16.dp),
//            verticalArrangement = Arrangement.spacedBy(16.dp)
//        ) {

//            item {
//                LazyRow (horizontalArrangement = Arrangement.spacedBy(16.dp)){
//                    items(pickups) { item ->
//                        val cardColor = getCardColor(item.statusId)
//                        PickupItem(
//                            pickupRecord = item,
//                            cardColor = CardDefaults.cardColors(Color.Yellow),
//                            context = context,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .clickable { onClickPickupCard(item.pickupRequestId) }
//                                .animateItemPlacement(),
//                            onClickLocation = onClickLocation,
//                            onClickCall = onClickCall,
//                            onClickEmail = onClickEmail,
//                            onClickDocument = onClickDocument
//                        )
//                    }
//                }
//            }


//            if (pickups.isNotEmpty())
//                stickyHeader(key = -1) {
//                    BoldText(
//                        text = "Number 1",
//                        textColor = Color.Black,
//                        modifier = stickyHeaderModifier
//                    )
//                }
//
//            items(items = pickups, key = {
//                it.pickupRequestId
//            }) { item: PickupRecord ->
//                val cardColor = getCardColor(item.statusId)
//                PickupItem(pickupRecord = item,
//                    cardColor = CardDefaults.cardColors(cardColor),
//                    context = context,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable { onClickPickupCard(item.pickupRequestId) }
//                        .animateItemPlacement(),
//                    onClickLocation = onClickLocation,
//                    onClickCall = onClickCall,
//                    onClickEmail = onClickEmail,
//                    onClickDocument = onClickDocument)
//            }
//
//
//            if (pickups.isNotEmpty())
//                stickyHeader(key = -2) {
//                    BoldText(
//                        text = "Number 2",
//                        textColor = Color.Black,
//                        modifier = stickyHeaderModifier
//                    )
//                }
//
//            items(items = pickups, key = {
//                it.pickupRequestId + 1000
//            }) { item: PickupRecord ->
//                val cardColor = getCardColor(item.statusId)
//                PickupItem(
//                    pickupRecord = item,
//                    cardColor = CardDefaults.cardColors(cardColor),
//                    context = context,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable { onClickPickupCard(item.pickupRequestId) }
//                        .animateItemPlacement(),
//                    onClickLocation = onClickLocation,
//                    onClickCall = onClickCall,
//                    onClickEmail = onClickEmail,
//                    onClickDocument = onClickDocument
//                )
//            }
//        }
//    }
}

val stickyHeaderModifier = Modifier
    .fillMaxWidth()
    .background(color = Color.White)
    .padding(bottom = 8.dp)


class A<T>{

}