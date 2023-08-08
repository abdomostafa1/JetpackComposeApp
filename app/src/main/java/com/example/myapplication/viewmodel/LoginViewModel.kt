package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _loggedInUserUiState = MutableStateFlow(LoggedInUser())
    val loggedInUserUiState = _loggedInUserUiState.asStateFlow()

    fun onChangeEmail(newValue: String) {
        _loggedInUserUiState.update {
            it.copy(email = newValue)
        }
    }

    fun onChangePassword(newValue: String) {
        _loggedInUserUiState.update {
            it.copy(password = newValue)
        }
    }

    fun onClickLogin() {
        Log.e("", _loggedInUserUiState.value.toString())
    }

}

data class LoggedInUser(val email: String = "", val password: String = "")