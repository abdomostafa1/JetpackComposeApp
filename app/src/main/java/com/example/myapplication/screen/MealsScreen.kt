package com.example.myapplication.screen

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication.R
import com.example.myapplication.composable.Icon
import com.example.myapplication.composable.MealCard
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


data class FoodMeal(val name: String, val photoId: Int)

val foodMeals = listOf(
    FoodMeal("Spaghetti Carbonara", R.drawable.spaghetti),
    FoodMeal("Chicken Alfredo", R.drawable.chicken_alfredo),
    FoodMeal("Hamburger", R.drawable.hamburger),
    FoodMeal("Caesar Salad", R.drawable.caesar_salad),
    FoodMeal("Sushi", R.drawable.sushi),
    FoodMeal("Pizza", R.drawable.pizza)
)

private const val TAG = "MealsScreen"

@Composable
fun MealsScreen() {
    var meals by remember {
        mutableStateOf(foodMeals)
    }
    var showFab = remember {
        mutableStateOf(true)
    }

    MealsContent(meals, showFab)
}

@Composable
private fun MealsContent(meals: List<FoodMeal>, showFab: MutableState<Boolean>) {

    ConstraintLayout(modifier = Modifier.padding(horizontal = 8.dp)) {

        val fab = createRef()
        val lazyListState = rememberLazyListState()
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 64.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            state = lazyListState
        ) {
            items(meals) {
                MealCard(foodMeal = it)
            }
        }

        Box(modifier = Modifier.constrainAs(fab) {
            bottom.linkTo(parent.bottom, 56.dp)
            end.linkTo(parent.end, 8.dp)
        }) {
            AnimatedVisibility(visible = showFab.value) {
                FloatingActionButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_24),
                        iconTint = Color.White
                    )
                }
            }
        }

        LaunchedEffect(key1 = meals) {
            snapshotFlow { lazyListState.isScrollInProgress }.collect {
                showFab.value = !it
            }
        }
    }

}