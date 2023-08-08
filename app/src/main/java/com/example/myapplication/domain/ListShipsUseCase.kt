package com.example.myapplication.domain

import com.example.myapplication.Token
import com.example.myapplication.data.ListRecieveRequest
import com.example.myapplication.data.ListShipsRequest
import com.example.myapplication.data.ListShipsResponse
import com.example.myapplication.data.OrderApi
import javax.inject.Inject

class ListShipsUseCase @Inject constructor(private val orderApi: OrderApi) {

    fun execute(): ListShipsResponse {
        val task=orderApi.fetchListShips(Token, ListShipsRequest()).execute()
        if (task.isSuccessful)
            return task.body()!!
        else
            throw Exception(task.errorBody().toString())
    }
}