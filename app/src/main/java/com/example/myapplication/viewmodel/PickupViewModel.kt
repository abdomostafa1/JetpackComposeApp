package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.PickupRecord
import com.example.myapplication.domain.ListPickupsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "PickupViewModel"

@HiltViewModel
class PickupViewModel @Inject constructor(private val listPickupsUseCase: ListPickupsUseCase) :
    ViewModel() {

    private val _pickupsResponse=MutableStateFlow<List<PickupRecord>>(emptyList())
    val pickupsResponse=_pickupsResponse.asStateFlow()
    fun fetchListPickups() {
        Log.e(TAG, "viewModel Start " )

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = listPickupsUseCase.execute()
                _pickupsResponse.value=response.pickupDTOs
                Log.e(TAG, "fetchListPickups=$response ")
            } catch (e: Exception) {
                Log.e(TAG, "${e.printStackTrace()}")
            }
        }
    }


}