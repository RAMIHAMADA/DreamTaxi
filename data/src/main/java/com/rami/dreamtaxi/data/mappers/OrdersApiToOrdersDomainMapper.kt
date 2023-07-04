package com.rami.dreamtaxi.data.mappers

import com.rami.dreamtaxi.data.data.remote.entities.EndAddressApi
import com.rami.dreamtaxi.data.data.remote.entities.OrderApi
import com.rami.dreamtaxi.data.data.remote.entities.PriceApi
import com.rami.dreamtaxi.data.data.remote.entities.StartAddressApi
import com.rami.dreamtaxi.domain.entities.EndAddress
import com.rami.dreamtaxi.domain.entities.Order
import com.rami.dreamtaxi.domain.entities.Price
import com.rami.dreamtaxi.domain.entities.StartAddress
import com.rami.dreamtaxi.domain.entities.Vehicle

import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

class OrdersApiToOrdersDomainMapper @Inject constructor() : (OrderApi) -> Order {


    override fun invoke(orderApi: OrderApi): Order {
        return Order(
            id = orderApi.id,
            startAddress = orderApi.startAddressApi.toStartAddress(),
            endAddress = orderApi.endAddressApi.toEndAddress(),
            price = orderApi.priceApi.toPrice(),
            orderTime = convertStringToTimestamp(orderApi.orderTime),
            vehicle = Vehicle(
                orderApi.vehicleApi.regNumber,
                orderApi.vehicleApi.modelName,
                orderApi.vehicleApi.photo,
                orderApi.vehicleApi.regNumber
            ),
        )
    }


    private fun StartAddressApi.toStartAddress(): StartAddress {
        return StartAddress(city = city, address = address)
    }

    private fun EndAddressApi.toEndAddress(): EndAddress {
        return EndAddress(city = city, address = address)
    }

    private fun PriceApi.toPrice(): Price {
        return Price(amount = amount, currency = currency)
    }


    private fun convertStringToTimestamp(dateTimeString: String): Long {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault())
        val date = format.parse(dateTimeString)
        return date?.time ?: 0

    }


}