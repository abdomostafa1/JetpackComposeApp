package com.example.myapplication.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface OrderApi {

    @POST("ListPickups")
    fun fetchListPickups(
        @Header("Authorization") key: String, @Body requestBody: ListPickupsRequest
    ): Call<ListPickupsResponse>

    @POST("ListShips")
    fun fetchListShips(
        @Header("Authorization") key: String, @Body requestBody: ListShipsRequest
    ): Call<ListShipsResponse>

    @POST("ListRecieve")
    fun fetchListReceives(
        @Header("Authorization") key: String, @Body requestBody: ListRecieveRequest
    ): Call<ListShipsResponse>


}