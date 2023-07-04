package com.rami.dreamtaxi.data.data.remote.entities

import com.google.gson.annotations.SerializedName


data class OrderApi(

    @SerializedName("id")
    val id: Int,

    @SerializedName("startAddress")
    val startAddressApi: StartAddressApi,

    @SerializedName("endAddress")
    val endAddressApi: EndAddressApi,

    @SerializedName("price")
    val priceApi: PriceApi,

    @SerializedName("orderTime")
    val orderTime: String,

    @SerializedName("vehicle")
    val vehicleApi: VehicleApi,
)