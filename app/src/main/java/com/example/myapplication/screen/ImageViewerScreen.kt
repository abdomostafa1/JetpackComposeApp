package com.example.myapplication.screen

import android.util.Log
import androidx.activity.SystemBarStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.AppStyle

private const val TAG = "ImageViewerScreen"
@Composable
fun ImageViewerScreen(navHostController: NavHostController, appStyle: AppStyle) {

    Log.e(TAG, "LocalLifecycleOwner.current=${LocalLifecycleOwner.current} ", )
    ImageViewerContent(onClickBackBtn = { navHostController.popBackStack() })
    appStyle.changeSystemBar(
        statusBarsStyle = SystemBarStyle.dark(Color.Black.toArgb()),
        navigationBarsStyle = SystemBarStyle.dark(Color.Black.toArgb())
    )
}

@Composable
fun ImageViewerContent(onClickBackBtn: () -> Unit) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (image, backIcon) = createRefs()

        Image(
            painter = painterResource(id = R.mipmap.app_icon),
            contentDescription = "abdo mostafa",
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(image) {}
        )

        Icon(
            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
            contentDescription = null,
            modifier = Modifier
                .clickable { onClickBackBtn() }
                .constrainAs(backIcon) {
                    top.linkTo(image.top, 16.dp)
                    start.linkTo(image.start, 8.dp)
                }
        )
    }
}