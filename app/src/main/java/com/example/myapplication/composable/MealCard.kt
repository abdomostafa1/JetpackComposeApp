package com.example.myapplication.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.screen.FoodMeal


@Composable
fun MealCard(foodMeal: FoodMeal) {
    val painter = painterResource(id = foodMeal.photoId)
    Card(shape = RoundedCornerShape(8.dp)) {
        Column {
            Image(
                painter = painter,
                contentDescription = "spaghetti",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            SpacerVertical8()
            NormalText(text = foodMeal.name, modifier = Modifier.padding(horizontal = 8.dp))
            SpacerVertical8()
        }
    }
}