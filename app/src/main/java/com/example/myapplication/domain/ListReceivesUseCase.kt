package com.example.myapplication.domain

import com.example.myapplication.Token
import com.example.myapplication.data.ListRecieveRequest
import com.example.myapplication.data.ListShipsResponse
import com.example.myapplication.data.OrderApi
import javax.inject.Inject

class ListReceivesUseCase @Inject constructor(private val orderApi: OrderApi) {

    fun execute(): ListShipsResponse {
        val task=orderApi.fetchListReceives(Token, ListRecieveRequest()).execute()
        if (task.isSuccessful)
            return task.body()!!
        else
            throw Exception(task.errorBody().toString())
    }
}