package com.rami.dreamtaxi.domain.usecases

import com.rami.dreamtaxi.domain.entities.Order
import com.rami.dreamtaxi.domain.repositories.OrdersRemoteRepository

class GetAllOrdersUseCase {
    private lateinit var _ordersRemoteRepository: OrdersRemoteRepository
    private val ordersRemoteRepository get() = _ordersRemoteRepository


    suspend fun getAllOrders(): List<Order> {
        val orders = ordersRemoteRepository.getAllOrders()
        return orders.sortedByDescending { it.orderTime }
    }
}