package com.example.myapplication.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun SmallText(text: String,textColor:Color) {
    Text(text = text, fontSize = 8.sp, fontWeight = FontWeight.Light, color = textColor, maxLines = 1)
}