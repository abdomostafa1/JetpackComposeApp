package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.PickupScreenState
import com.example.myapplication.domain.ListPickupsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "PickupViewModel"

@HiltViewModel
class PickupViewModel @Inject constructor(private val listPickupsUseCase: ListPickupsUseCase) :
    ViewModel() {

    private val _pickupScreenState = MutableStateFlow<PickupScreenState>(PickupScreenState.Loading)
    val pickupScreenState = _pickupScreenState.asStateFlow()

    init {
        fetchListPickups()
    }

    private fun fetchListPickups() {
        Log.e(TAG, "viewModel Start ")

        viewModelScope.launch(Dispatchers.IO) {
            try {
                delay(3000)
                val response = listPickupsUseCase.execute()
                _pickupScreenState.value = PickupScreenState.Success(response.pickupDTOs)
                Log.e(TAG, "fetchListPickups=$response ")
            } catch (e: Exception) {
                _pickupScreenState.value = PickupScreenState.Error(e.stackTraceToString())
                Log.e(TAG, "${e.printStackTrace()}")
            }
        }
    }

    fun onClickPickupCard(pickupRequestId: Int) {
        val pickups = (_pickupScreenState as PickupScreenState.Success).pickups

        val filteredList = pickups.filterNot { pickupRecord ->
            pickupRecord.pickupRequestId == pickupRequestId
        }
        _pickupScreenState.value = PickupScreenState.Success(filteredList)
    }
}
