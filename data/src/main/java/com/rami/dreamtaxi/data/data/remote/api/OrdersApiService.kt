package com.rami.dreamtaxi.data.data.remote.api

import com.rami.dreamtaxi.data.data.remote.entities.OrderApi
import retrofit2.http.GET

interface OrdersApiService {

    @GET("/careers/test/orders.json")
    suspend fun getOrders(): List<OrderApi>
}