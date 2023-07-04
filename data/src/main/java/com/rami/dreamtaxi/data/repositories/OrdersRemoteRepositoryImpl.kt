package com.rami.dreamtaxi.data.repositories


import com.rami.dreamtaxi.data.mappers.OrdersApiToOrdersDomainMapper
import com.rami.dreamtaxi.data.data.remote.api.OrdersApiService
import com.rami.dreamtaxi.domain.entities.Order
import com.rami.dreamtaxi.domain.repositories.OrdersRemoteRepository
import javax.inject.Inject

class OrdersRemoteRepositoryImpl @Inject constructor(
    private val ordersApiService: OrdersApiService,
    private val ordersApiToOrdersDomainMapper: OrdersApiToOrdersDomainMapper,
) : OrdersRemoteRepository {

    override suspend fun getAllOrders(): List<Order> {
        return ordersApiService.getOrders().map(ordersApiToOrdersDomainMapper)
    }
}