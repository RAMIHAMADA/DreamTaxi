package com.rami.dreamtaxi.domain.entities


data class Order(
    val id: Int,
    val startAddress: StartAddress,
    val endAddress: EndAddress,
    val price: Price,
    val orderTime: Long,
    val vehicle: Vehicle,
)
