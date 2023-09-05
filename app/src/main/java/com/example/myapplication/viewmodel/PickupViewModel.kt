package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.PickupRecord
import com.example.myapplication.domain.ListPickupsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "PickupViewModel"

@HiltViewModel
class PickupViewModel @Inject constructor(private val listPickupsUseCase: ListPickupsUseCase) :
    ViewModel() {

    private val _pickupsList = MutableStateFlow<List<PickupRecord>>(emptyList())
    val pickupsList = _pickupsList.asStateFlow()

    init {
        fetchListPickups()
    }
    private fun fetchListPickups() {
        Log.e(TAG, "viewModel Start ")

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = listPickupsUseCase.execute()
                _pickupsList.value = response.pickupDTOs
                Log.e(TAG, "fetchListPickups=$response ")
            } catch (e: Exception) {
                Log.e(TAG, "${e.printStackTrace()}")
            }
        }
    }

    fun onClickPickupCard(pickupRequestId: Int) {
        _pickupsList.update {
            it.filterNot { pickupRecord ->
                pickupRecord.pickupRequestId == pickupRequestId
            }
        }
    }

}