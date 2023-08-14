package com.example.myapplication.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.abdo
import com.example.myapplication.composable.SpacerVertical64
import com.example.myapplication.ui.theme.LightRed
import com.example.myapplication.viewmodel.LoggedInUser
import com.example.myapplication.viewmodel.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun LoginScreen() {
    val viewModel: LoginViewModel = viewModel()
    val state by viewModel.loggedInUserUiState.collectAsState()
    LoginContent(
        state,
        viewModel::onChangeEmail,
        viewModel::onChangePassword,
        viewModel::onClickLogin
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoginContent(
    state: LoggedInUser,
    onChangeEmail: (String) -> Unit,
    onChangePassword: (String) -> Unit,
    onClickLogin: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.mipmap.red_icon),
                contentDescription = String().abdo,
                modifier = Modifier
                    .size(150.dp)
                    .padding(top = 64.dp)
                    .background(Color.White, CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(64.dp))

        TextField(
            value = state.email,
            onValueChange = onChangeEmail,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.password,
            onValueChange = onChangePassword,
            modifier = Modifier.fillMaxWidth()
        )
        SpacerVertical64()
        Button(
            onClick = onClickLogin,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                LightRed
            )
        ) {
            Text(text = "Login")
        }
    }
}