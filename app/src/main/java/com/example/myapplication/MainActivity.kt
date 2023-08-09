package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.composable.LoginScreen
import com.example.myapplication.composable.PickupScreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.viewmodel.PickupViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    PickupScreen(
                        context = this,
                        onClickLocation =onClickButtonLocation,
                        onClickCall =onClickButtonCall,
                        onClickEmail =onClickButtonEmail,
                        onClickDocument =onClickButtonDocument
                    )
                }
                Toast(this@MainActivity).showLongToast(this@MainActivity, "ana abdo mostafa")
            }
        }
    }

    private val onClickButtonLocation: (String) -> Unit = { location: String ->
        // Create a Uri from an intent string. Use the result to create an Intent.
        val gmmIntentUri = Uri.parse(location)

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps")

        mapIntent.resolveActivity(this.packageManager)?.let {
            // Attempt to start an activity that can handle the Intent
            startActivity(mapIntent)
        }
    }
    private val onClickButtonCall: (String) -> Unit = { phone: String ->
        // To do
    }
    private val onClickButtonEmail: (String) -> Unit = { email: String ->
        // To do
    }
    private val onClickButtonDocument: (String) -> Unit = { document: String ->
        // To do
    }

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val text by remember {
        mutableStateOf(5)
    }
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}