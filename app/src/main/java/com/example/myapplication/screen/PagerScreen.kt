package com.example.myapplication.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.myapplication.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PagerScreen() {
    PagerContent()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PagerContent() {

    val coroutineScope= rememberCoroutineScope()

    val state = rememberPagerState {
        3
    }
    HorizontalPager(state = state, modifier = Modifier.fillMaxSize()) {
        when (it) {
            0 -> {
                Image(
                    painter = painterResource(id = R.mipmap.app_icon),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }

            1 -> {
                Image(
                    painter = painterResource(id = R.mipmap.img2),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }

            2 -> {
                Image(
                    painter = painterResource(id = R.mipmap.profile_picture),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

    LaunchedEffect(key1 = true){
        while (true){
            delay(3000)
            if (!state.canScrollForward)
                state.animateScrollToPage(0)
            else{
                state.animateScrollToPage(state.currentPage+1)
            }
        }
    }
}