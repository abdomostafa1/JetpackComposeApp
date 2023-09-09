package com.example.myapplication.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.composable.BoldText


val colors = listOf(
    Color.Cyan,
    Color.Red,
    Color.Blue,
    Color.Yellow,
    Color.DarkGray,
    Color.Gray,
    Color.Green,
    Color.Magenta,
    Color.LightGray
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowLayoutScreen() {
    val names = listOf<String>(
        "abdo", "ahmed", "sayed", "ali", "mohamed", "tamer", "mohsen", "mostafa", "mahmoud",
        "yasser", "abdelgawad", "zarea", "saad", "yousef", "asar", "lareyn", "gomma"
    )


    FlowRow(modifier = Modifier.padding(vertical = 32.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        names.forEach { name ->
            SpecialText(text = name)
        }
    }
}




@Composable
fun SpecialText(text: String) {

    BoldText(
        text = text, textColor = Color.White, modifier = Modifier
            .background(color = colors.random(), shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
    )
}