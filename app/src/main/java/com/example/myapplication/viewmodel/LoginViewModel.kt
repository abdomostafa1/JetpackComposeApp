package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.ListPickupsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "LoginViewModel"
@HiltViewModel
class LoginViewModel @Inject constructor(private val listPickupsUseCase: ListPickupsUseCase): ViewModel() {

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
        fetchListPickups()
    }

    fun fetchListPickups() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = listPickupsUseCase.execute()
                Log.e(TAG, "fetchListPickups=$response ")
            } catch (e: Exception) {
                Log.e(TAG, "${e.printStackTrace()}")
            }
        }
    }
}

data class LoggedInUser(val email: String = "", val password: String = "")