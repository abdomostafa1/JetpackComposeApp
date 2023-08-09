package com.example.myapplication.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun Icon(painter: Painter, iconTint: Color, modifier: Modifier=Modifier) {
    Icon(
        painter = painter,
        contentDescription = "",
        modifier = modifier,
        tint = iconTint
    )
}