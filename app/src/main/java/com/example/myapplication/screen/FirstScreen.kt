package com.example.myapplication.screen

import androidx.activity.SystemBarStyle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.myapplication.AppStyle
import com.example.myapplication.NavDestination
import com.example.myapplication.composable.BoldText
import com.example.myapplication.composable.NormalText

@Composable
fun FirstScreen(navController: NavController, appStyle: AppStyle) {

    appStyle.changeSystemBar(
        statusBarsStyle = SystemBarStyle.light(Color.White.toArgb(), Color.Black.toArgb()),
        navigationBarsStyle = SystemBarStyle.light(Color.White.toArgb(), Color.Black.toArgb())
    )
    FirstContent(onClickOpen = { navController.navigate(NavDestination.imageViewerScreen) })
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FirstContent(onClickOpen: () -> Unit) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        val (firstScreen, open) = createRefs()
        val guideline30 = createGuidelineFromTop(0.30f)

        BoldText(text = "First Screen", modifier = Modifier.constrainAs(firstScreen) {
            top.linkTo(guideline30)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })


        Button(onClick = { onClickOpen() }, modifier = Modifier.constrainAs(open) {
            top.linkTo(firstScreen.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            NormalText(text = "Open Photo", textColor = Color.White)
        }


    }

}