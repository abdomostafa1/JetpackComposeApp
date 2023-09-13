package com.example.myapplication.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.NavDestination
import com.example.myapplication.R
import com.example.myapplication.composable.BoldText
import com.example.myapplication.composable.Icon
import com.example.myapplication.composable.NormalText
import com.example.myapplication.viewmodel.CounterViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "CounterScreen"
@Composable
fun CounterScreen() {
    val viewModel: CounterViewModel = viewModel()
    val counter by viewModel.counter.collectAsState()
    CounterContent(counter, viewModel::incrementCounter, viewModel::decrementCounter)
}

@Composable
private fun CounterContent(counter: Int, onClickPlus: () -> Unit, onClickMinus: () -> Unit) {

    val coroutineScope= rememberCoroutineScope()
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (text, plus, minus,welcomeCoroutine) = createRefs()
        val guideline30 = createGuidelineFromTop(0.30f)
        val guideline70 = createGuidelineFromTop(0.70f)
        val horizontalChain =
            createHorizontalChain(
                chainStyle = ChainStyle.Spread,
                elements = arrayOf(plus, minus)
            )
        BoldText(text = counter.toString(), modifier = Modifier.constrainAs(text) {
            top.linkTo(guideline30)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })


        Button(
            onClick = { onClickPlus() },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
            modifier = Modifier.constrainAs(plus) {
                bottom.linkTo(guideline70)
            }) {
            NormalText(text = "+", textColor = Color.Black)
        }

        Button(
            onClick = { onClickMinus() },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
            modifier = Modifier.constrainAs(minus) {
                bottom.linkTo(guideline70)
            }) {
            NormalText(text = "-", textColor = Color.Black)
        }

        Button(
            onClick = { coroutineScope.launch (Dispatchers.IO){
                Log.e(TAG, "CounterContent: hahahahaaaaaa ", )
            } },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
            modifier = Modifier.constrainAs(welcomeCoroutine) {
                bottom.linkTo(parent.bottom,16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            BoldText(text = "Welcome Coroutine", textColor = Color.Black)
        }

        Log.e(TAG, "LocalLifecycleOwner.current=${LocalLifecycleOwner.current} ", )
        LaunchedEffect(key1 = 0 ){
            Log.e(TAG, "Counter=$counter ", )
        }
    }

}