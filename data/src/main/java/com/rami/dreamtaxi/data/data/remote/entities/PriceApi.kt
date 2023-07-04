package com.rami.dreamtaxi.data.data.remote.entities

import com.google.gson.annotations.SerializedName


data class PriceApi(

    @SerializedName("amount")
    val amount: Int,

    @SerializedName("currency")
    val currency: String,
)