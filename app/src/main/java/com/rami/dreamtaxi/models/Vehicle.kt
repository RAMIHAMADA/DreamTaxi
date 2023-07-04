package com.rami.dreamtaxi.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vehicle(
  val regNumber: String,
  val modelName: String,
  val photo: String,
  val driverName: String,
): Parcelable