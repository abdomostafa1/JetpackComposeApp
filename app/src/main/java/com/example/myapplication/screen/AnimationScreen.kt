package com.example.myapplication.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication.R
import com.example.myapplication.composable.Icon
import com.example.myapplication.composable.NormalText
import com.example.myapplication.composable.SpacerVertical16
import com.example.myapplication.composable.SpacerVertical64
import com.example.myapplication.composable.SpacerVertical8

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
    AnimationContent(showDetails,icon)
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
                .animateContentSize(animationSpec = tween(1000)),
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
                    Icon(
                        painter = painterResource(iconId),
                        iconTint = Color.White,
                        modifier = Modifier
                            .padding(8.dp)
                            .background(Color.Black, CircleShape)
                            .clickable { showDetails.value = !showDetails.value }
                            .constrainAs(icon) {
                                top.linkTo(parent.top)
                                end.linkTo(parent.end)
                            }
                    )

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
