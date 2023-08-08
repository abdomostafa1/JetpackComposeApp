package com.example.myapplication.domain

import com.example.myapplication.Token
import com.example.myapplication.data.ListPickupsRequest
import com.example.myapplication.data.ListPickupsResponse
import com.example.myapplication.data.ListRecieveRequest
import com.example.myapplication.data.OrderApi
import javax.inject.Inject

class ListPickupsUseCase @Inject constructor(private val orderApi: OrderApi) {

    fun execute(): ListPickupsResponse {
        val task=orderApi.fetchListPickups(Token, ListPickupsRequest()).execute()
        if (task.isSuccessful)
            return task.body()!!
        else
            throw Exception(task.errorBody().toString())
    }
}