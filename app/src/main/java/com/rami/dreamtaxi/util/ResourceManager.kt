package com.rami.dreamtaxi.util

import android.app.Application
import android.content.res.Resources
import javax.inject.Inject

class ResourceManager @Inject constructor(
    private val context: Application,
) {

    private val resources: Resources
        get() = context.resources

    fun getString(id: Int): String {
        return resources.getString(id)
    }

    fun getString(id: Int, vararg: Any): String {
        return resources.getString(id, vararg)
    }
}