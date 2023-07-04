package com.rami.dreamtaxi.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rami.dreamtaxi.domain.entities.Order
import com.rami.dreamtaxi.domain.usecases.GetAllOrdersUseCase
import com.rami.dreamtaxi.mappers.OrdersToOrdersItemMapper
import com.rami.dreamtaxi.models.OrderItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OrdersViewModel @Inject constructor(
    private val getAllOrdersUseCase: GetAllOrdersUseCase,
    private val ordersToOrdersItemMapper: OrdersToOrdersItemMapper,
) : ViewModel() {

    private val _orders: MutableStateFlow<List<Order>> = MutableStateFlow(emptyList())
    val orders = _orders.asStateFlow()

    private val _ordersItem: MutableStateFlow<List<OrderItem>> = MutableStateFlow(emptyList())
    val ordersItem = _ordersItem.asStateFlow()

    init {
        getAllOrders()
    }

    fun getOrder(id: Int): OrderItem? {
        return ordersItem.value.find {
            it.id == id
        }
    }

    private fun getAllOrders() {
        viewModelScope.launch(Dispatchers.Default) {
            val newList = getAllOrdersUseCase.getAllOrders()
            _orders.value = newList
            _ordersItem.value = newList.map(ordersToOrdersItemMapper)
        }
    }
}