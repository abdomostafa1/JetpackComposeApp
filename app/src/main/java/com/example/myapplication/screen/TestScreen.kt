package com.example.myapplication.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.composable.NormalText
import com.example.myapplication.composable.SpacerVertical16
import com.example.myapplication.composable.SpacerVertical32
import com.example.myapplication.composable.SpacerVertical64

val hanaBakerMessages =
    listOf(
        "Hi this is hannah baker",
        "i know you does n't belong to this list",
        "but you need to be here if i'm going o tell my story",
        "if i'm going to tell",
        "why i did what i did",
        "cause you",
        "good , kind and decent",
        "and i didn't deserve to be with",
        "someone like you"
    )

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun TestScreen() {

    //val login=Login()
    var showImage by remember {
        mutableStateOf(false)
    }

    var message by remember {
        mutableStateOf(hanaBakerMessages[0])
    }

    var index by remember {
        mutableIntStateOf(0)
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SpacerVertical32()

        Button(onClick = {
            index++
            message = "$message ${hanaBakerMessages[index]}"
        }, shape = RoundedCornerShape(8.dp)) {
            NormalText(text = "animate text", textColor = Color.White)
        }
        SpacerVertical32()
        Box(modifier = Modifier
            .background(Color.Yellow)
            .animateContentSize()
        ) {
            NormalText(
                text = message,
            )
        }

        SpacerVertical64()
        Button(onClick = { showImage = !showImage }) {
            NormalText(text = "on click", textColor = Color.White)
        }

        SpacerVertical16()
        AnimatedVisibility(
            visible = showImage,
            enter = fadeIn(animationSpec= tween(3000)),
            exit = fadeOut(animationSpec = tween(3000))
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.spaghetti),
                    contentDescription = "spaghetti",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(shape = RoundedCornerShape(16.dp), color = Color.White)
                )
//
//                SpacerVertical32()
//
//                Image(
//                    painter = painterResource(id = R.drawable.pizza),
//                    contentDescription = "pizza",
//                    contentScale = ContentScale.FillWidth,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(200.dp)
//                        .background(shape = RoundedCornerShape(16.dp), color = Color.White)
//                        .animateEnterExit(
//                            enter = slideIn { it -> IntOffset(it.width, it.height) },
//                            exit = slideOut { it -> IntOffset(-it.width, it.height) }
//                        )
//                )
            }

        }
    }
}

  
