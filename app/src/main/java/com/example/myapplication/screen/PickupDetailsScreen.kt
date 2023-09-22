package com.example.myapplication.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.myapplication.NavDestination
import com.example.myapplication.R
import com.example.myapplication.composable.BoldText
import com.example.myapplication.composable.Icon
import com.example.myapplication.composable.NormalText

@Composable
fun PickupDetailsScreen(navController: NavController, id: Int) {
    PickupDetailsContent(
        id,
        onClickUpBtn = { navController.navigateUp() },
        onClickNext = { navController.navigate(NavDestination.thirdScreen) }
    )
}

@Composable
private fun PickupDetailsContent(shipmentId:Int,onClickUpBtn: () -> Unit, onClickNext: () -> Unit) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        val (upBtn, pickupDetails, id, next) = createRefs()
        val guideline30 = createGuidelineFromTop(0.30f)
        Icon(
            painter = painterResource(id = 0),
            iconTint = Color.Black,
            modifier = Modifier
                .clickable { onClickUpBtn() }
                .constrainAs(upBtn) {
                    top.linkTo(parent.top, 16.dp)
                    start.linkTo(parent.start, 8.dp)
                }
        )

        BoldText(
            text = "Pickup Details",
            modifier = Modifier.constrainAs(pickupDetails) {
                top.linkTo(guideline30)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        BoldText(
            text = "$shipmentId",
            modifier = Modifier.constrainAs(id) {
                top.linkTo(pickupDetails.bottom, 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Button(onClick = { onClickNext() }, modifier = Modifier.constrainAs(next) {
            top.linkTo(id.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            NormalText(text = "Next")
        }
    }

}