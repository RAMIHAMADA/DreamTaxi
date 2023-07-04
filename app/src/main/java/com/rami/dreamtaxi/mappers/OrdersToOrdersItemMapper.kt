package com.rami.dreamtaxi.mappers

import com.rami.dreamtaxi.R
import com.rami.dreamtaxi.domain.entities.EndAddress
import com.rami.dreamtaxi.domain.entities.Order
import com.rami.dreamtaxi.domain.entities.Price
import com.rami.dreamtaxi.domain.entities.StartAddress
import com.rami.dreamtaxi.models.OrderItem
import com.rami.dreamtaxi.models.Vehicle
import com.rami.dreamtaxi.util.ResourceManager
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class OrdersToOrdersItemMapper @Inject constructor(
    private val resourceManager: ResourceManager,
) : (Order) -> OrderItem {

    override fun invoke(order: Order): OrderItem {
        return OrderItem(
            id = order.id,
            startAddress = getStartAddress(order.startAddress),
            endAddress = getEndAddress(order.endAddress),
            orderTime = getTime(order.orderTime),
            orderTimeGeneral = order.orderTime,
            price = getPrice(order.price),
            vehicle = Vehicle(
                regNumber = order.vehicle.regNumber,
                modelName = order.vehicle.modelName,
                photo = order.vehicle.photo,
                driverName = order.vehicle.driverName
            )
        )
    }

    private fun getStartAddress(startAddress: StartAddress): String {
        val address = "${startAddress.city}\n${startAddress.address}"
        return resourceManager.getString(R.string.start_address, address)
    }

    private fun getEndAddress(endAddress: EndAddress): String {
        val address = "${endAddress.city}\n${endAddress.address}"
        return resourceManager.getString(R.string.end_address, address)
    }

    private fun getTime(longValue: Long): String {
        val date = Date(longValue)
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return format.format(date)
    }

    // TODO add normal method witch get price like string
    private fun getPrice(price: Price): String {
        return "${price.amount} ${price.currency}"
    }
}