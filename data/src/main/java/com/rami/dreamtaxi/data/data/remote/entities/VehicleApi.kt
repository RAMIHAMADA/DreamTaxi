package com.rami.dreamtaxi.data.data.remote.entities

import com.google.gson.annotations.SerializedName


data class VehicleApi(

    @SerializedName("regNumber")
    val regNumber: String,

    @SerializedName("modelName")
    val modelName: String,

    @SerializedName("photo")
    val photo: String,

    @SerializedName("driverName")
    val driverName: String,
)