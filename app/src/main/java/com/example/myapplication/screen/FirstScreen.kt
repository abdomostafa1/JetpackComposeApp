package com.example.myapplication.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.SystemBarStyle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.myapplication.AppStyle
import com.example.myapplication.NavDestination
import com.example.myapplication.R
import com.example.myapplication.composable.BoldText
import com.example.myapplication.composable.NormalText
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

private const val TAG = "FirstScreen"

@Composable
fun FirstScreen(navController: NavController, appStyle: AppStyle) {

    val showWebViewState = remember {
        mutableStateOf(false)
    }
    Log.e(TAG, "LocalLifecycleOwner.current=${LocalLifecycleOwner.current} ")
    appStyle.changeSystemBar(
        statusBarsStyle = SystemBarStyle.light(Color.White.toArgb(), Color.Black.toArgb()),
        navigationBarsStyle = SystemBarStyle.light(Color.White.toArgb(), Color.Black.toArgb())
    )
    FirstContent(showWebView = showWebViewState,
        onClickOpenPhoto = { navController.navigate(NavDestination.imageViewerScreen) })

    DisposableEffect(key1 = "iik") {


        onDispose {

        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
private fun FirstContent(showWebView: MutableState<Boolean>, onClickOpenPhoto: () -> Unit) {


//    val state = rememberWebViewState(url = "https://www.google.com")
//    WebView(state = state, modifier = Modifier.fillMaxSize().padding(vertical = 24.dp))


    Log.e(TAG, "showWebView=${showWebView.value} ")
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {

        val (firstScreen, openPhoto, openGoogle, webView) = createRefs()
        val guideline30 = createGuidelineFromTop(0.30f)

        BoldText(text = "First Screen", modifier = Modifier.constrainAs(firstScreen) {
            top.linkTo(guideline30)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })


        Button(onClick = { onClickOpenPhoto() }, modifier = Modifier.constrainAs(openPhoto) {
            top.linkTo(firstScreen.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            NormalText(text = "Open Photo", textColor = Color.White)
        }

        Button(onClick = { showWebView.value = true }, modifier = Modifier.constrainAs(openGoogle) {
            top.linkTo(openPhoto.bottom, 16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            NormalText(text = "Open Google", textColor = Color.White)
        }


        if (showWebView.value) {
            Log.e(TAG, "inside showWebView ")
            val state = rememberWebViewState(url = "https://www.google.com")
            WebView(
                state = state,
                onCreated = {
                    it.settings.javaScriptEnabled = true
                },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp)
            )
        }
    }

}
