package com.example.myapplication.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor():ViewModel() {

    private val _counter= MutableStateFlow(0)
    val counter=_counter.asStateFlow()

    fun incrementCounter(){
        _counter.update { it->
            it+1
        }
    }
    fun decrementCounter(){
        _counter.update { it->
            it-1
        }
    }

}