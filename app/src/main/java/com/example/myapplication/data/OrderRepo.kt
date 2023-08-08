package com.example.myapplication.data

interface OrderRepo {

    fun fetchListPickups():Any
    fun fetchListReceives():Any
    fun fetchListShips():Any
}