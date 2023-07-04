package com.rami.dreamtaxi.domain.repositories

import com.rami.dreamtaxi.domain.entities.Order

interface OrdersRemoteRepository {

    suspend fun getAllOrders(): List<Order>
}