package com.rami.dreamtaxi.domain.usecases

import com.rami.dreamtaxi.domain.entities.Order
import com.rami.dreamtaxi.domain.repositories.OrdersRemoteRepository
import javax.inject.Inject

class GetAllOrdersUseCase @Inject constructor(
    private val ordersRemoteRepository: OrdersRemoteRepository,
) {

    suspend fun getAllOrders(): List<Order> {
        val orders = ordersRemoteRepository.getAllOrders()
        return orders.sortedByDescending { it.orderTime }
    }
}