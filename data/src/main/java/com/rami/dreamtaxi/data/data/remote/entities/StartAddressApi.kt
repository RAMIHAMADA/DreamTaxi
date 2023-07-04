package com.rami.dreamtaxi.data.data.remote.entities

import com.google.gson.annotations.SerializedName


data class StartAddressApi(

    @SerializedName("city")
    val city: String,

    @SerializedName("address")
    val address: String,
)