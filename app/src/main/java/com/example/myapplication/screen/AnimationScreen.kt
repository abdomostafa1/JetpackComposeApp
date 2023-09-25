package com.example.myapplication.screen

import android.util.Log
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication.R
import com.example.myapplication.composable.Icon
import com.example.myapplication.composable.NormalText
import com.example.myapplication.composable.SpacerVertical16
import com.example.myapplication.composable.SpacerVertical32
import com.example.myapplication.composable.SpacerVertical64
import com.example.myapplication.composable.SpacerVertical8
import com.example.myapplication.ui.theme.Purple40
import com.example.myapplication.ui.theme.PurpleGrey40

private const val TAG = "AnimationScreen"

@Composable
fun AnimationScreen() {

    var showDetails = remember {
        mutableStateOf(false)
    }
    val icon by remember {
        derivedStateOf {
            if (showDetails.value)
                R.drawable.ic_arrow_up_24
            else
                R.drawable.ic_arrow_down_24
        }
    }
    AnimationContent(showDetails, icon)


//    val infiniteTransition = rememberInfiniteTransition("background color")
//
//    val color by infiniteTransition.animateColor(
//        initialValue = Orange, targetValue = Color.LightGray,
//        animationSpec = infiniteRepeatable(
//            animation = tween(1000),
//            repeatMode = RepeatMode.Reverse
//        ),
//        label = "card color"
//    )
//    val float by infiniteTransition.animateFloat(
//        initialValue = 50f,
//        targetValue = 280f,
//        animationSpec = InfiniteRepeatableSpec(tween(4000), RepeatMode.Reverse),
//        label = "width values"
//    )
//    AnimationContent2(color = color, float)

//    var isSelected by remember {
//        mutableStateOf(false)
//    }
//    val transation = updateTransition(targetState = isSelected, label = "selection transition")
//    val color by transation.animateColor(label = "selection color") {
//        when (it) {
//            false -> PurpleGrey40
//            true -> Purple40
//        }
//    }
//    val strokeWidth by transation.animateDp(label = "card stroke width") {
//        when (it) {
//            true -> 2.dp
//            false -> 0.dp
//        }
//    }
//
//    val cardWidth by transation.animateDp(
//        transitionSpec = {
//            spring(dampingRatio = Spring.DampingRatioHighBouncy, stiffness = Spring.StiffnessMedium)
//        }, label = "cardWidth"
//    ) {
//        when (it) {
//            true -> 256.dp
//            false -> 128.dp
//        }
//    }
//
//    AnimationContent3(color = color,
//        borderWidth = strokeWidth,
//        cardWidth = cardWidth,
//        onClick = { isSelected = !isSelected })


//    var isSelected by remember {
//        mutableStateOf(false)
//    }
//
//    val color by animateColorAsState(
//        targetValue = if (isSelected) Purple40 else Color.Gray, animationSpec = tween(2000),
//        label = "icon color"
//    )
//    val borderWidth by animateDpAsState(if (isSelected) 2.dp else 0.dp, label = "stroke width")
//
//    val cardWidth by animateDpAsState(if (isSelected) 256.dp else 128.dp, label = "card width")
//    //Log.e(TAG, "color:$color " )
//    Log.e(TAG, "borderWidth:$borderWidth ")
//    AnimationContent3(color = color, borderWidth = 0.dp, cardWidth = cardWidth) {
//        isSelected = !isSelected
//    }
}

@Composable
private fun AnimationContent(showDetails: MutableState<Boolean>, iconId: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SpacerVertical64()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .animateContentSize(
                    spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessVeryLow
                    )
                ),
            border = BorderStroke(2.dp, Color.White),
            colors = CardDefaults.cardColors(containerColor = Color.Black)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                    val (icon, shipment) = createRefs()
                    NormalText(text = "SH16", textColor = Color.White)
                    Icon(painter = painterResource(iconId),
                        iconTint = Color.White,
                        modifier = Modifier
                            .padding(8.dp)
                            .background(Color.Black, CircleShape)
                            .clickable { showDetails.value = !showDetails.value }
                            .constrainAs(icon) {
                                top.linkTo(parent.top)
                                end.linkTo(parent.end)
                            })

                }

                if (showDetails.value) {
                    SpacerVertical8()
                    NormalText(text = "Courier: Abdo", textColor = Color.White)
                    SpacerVertical8()
                    NormalText(text = "Size: 10kg", textColor = Color.White)
                    SpacerVertical8()
                    NormalText(text = "Quantity: 10", textColor = Color.White)
                    SpacerVertical8()
                    NormalText(text = "Price: 10000", textColor = Color.White)
                    SpacerVertical8()

                }

            }
        }
        SpacerVertical8()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, RoundedCornerShape(16.dp))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            NormalText(text = "One")
        }
        SpacerVertical16()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, RoundedCornerShape(16.dp))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            NormalText(text = "Two")
        }
        SpacerVertical16()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, RoundedCornerShape(16.dp))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            NormalText(text = "3")
        }
        SpacerVertical16()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, RoundedCornerShape(16.dp))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            NormalText(text = "4")
        }
        SpacerVertical16()

    }
}


@Composable
private fun AnimationContent2(color: Color, width: Float) {

    Log.e(TAG, "color=$color ")
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        SpacerVertical64()
        Card(
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(8.dp)),
            colors = CardDefaults.cardColors(containerColor = color)
        ) {}

        SpacerVertical32()
        Card(
            modifier = Modifier
                .height(128.dp)
                .width(width.dp)
                .clip(RoundedCornerShape(8.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.Red)
        ) {}
    }

}

@Composable
private fun AnimationContent3(color: Color, borderWidth: Dp, cardWidth: Dp, onClick: () -> Unit) {

    Log.e(TAG, "color=$color ")
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        SpacerVertical64()
        Card(
            modifier = Modifier
                .height(128.dp)
                .width(cardWidth)
                .clip(RoundedCornerShape(8.dp))
                .clickable { onClick() },
            border = BorderStroke(borderWidth, color)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(id = R.drawable.baseline_call_24), iconTint = color)
            }
        }

    }

}
