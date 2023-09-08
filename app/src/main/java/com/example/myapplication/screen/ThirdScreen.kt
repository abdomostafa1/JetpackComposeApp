package com.example.myapplication.screen

import androidx.compose.foundation.background
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
fun ThirdScreen(navController: NavController) {
    ThirdContent(onClickBack = { navController.popBackStack(NavDestination.pickupScreen,false) })
}

@Composable
private fun ThirdContent(onClickBack: () -> Unit) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        val (upBtn, pickupDetails, id, back) = createRefs()
        val guideline30 = createGuidelineFromTop(0.30f)

        BoldText(text = "Third Screen", modifier = Modifier.constrainAs(pickupDetails) {
            top.linkTo(guideline30)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        BoldText(text = "The End", modifier = Modifier.constrainAs(id) {
            top.linkTo(pickupDetails.bottom, 16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        Button(onClick = { onClickBack() }, modifier = Modifier.constrainAs(back) {
            top.linkTo(id.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            NormalText(text = "back", textColor = Color.White)
        }
    }

}