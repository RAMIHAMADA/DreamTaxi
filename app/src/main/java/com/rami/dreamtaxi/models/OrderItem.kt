package com.rami.dreamtaxi.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class OrderItem(
    val id: Int,
    val startAddress: String,
    val endAddress: String,
    val price: String,
    val orderTime: String,
    val orderTimeGeneral: Long,
    val vehicle: Vehicle,
) : Parcelable
