package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.ListPickupsUseCase
import javax.inject.Inject

class PickupViewModel @Inject constructor(val listPickupsUseCase: ListPickupsUseCase) : ViewModel() {


}