package com.rami.dreamtaxi.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rami.dreamtaxi.R
import com.rami.dreamtaxi.databinding.FragmentDetalisOrderBinding
import com.rami.incredibletaxiorders.OrdersDetailsFragmentArgs

class OrdersDetailsFragment : Fragment(R.layout.fragment_detalis_order) {

    private val binding: FragmentDetalisOrderBinding by viewBinding()

    private val args by navArgs<OrdersDetailsFragmentArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("COP", "onViewCreated: ${args.order}")
    }


}