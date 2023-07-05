package com.rami.dreamtaxi.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.rami.dreamtaxi.R
import com.rami.dreamtaxi.databinding.FragmentDetalisOrderBinding
import java.text.SimpleDateFormat

class OrdersDetailsFragment : Fragment(R.layout.fragment_detalis_order) {

    private val binding: FragmentDetalisOrderBinding by viewBinding()

    private val args by navArgs<OrdersDetailsFragmentArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickArrowBack()
        transferInfo()
    }

    private fun initClickArrowBack() {
        binding.backgroundForArrowV.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun transferInfo() {
        binding.startAdressTv.text = args.order.startAddress
        binding.endAdressTv.text = args.order.endAddress
        binding.modelNameTv.text = args.order.vehicle.modelName
        binding.regNumberTv.text = args.order.vehicle.regNumber
        binding.driverTv.text = args.order.vehicle.driverName
        binding.dateTv.text = args.order.orderTime
        binding.timeTv.text = convertLongToTime(args.order.orderTimeGeneral)
        binding.costTv.text = args.order.price
        loadPhoto()
    }


    private fun loadPhoto() {
        Glide.with(requireContext())
            .load("https://www.roxiemobile.ru/careers/test/images/${args.order.vehicle.photo}")
            .placeholder(R.drawable.baseline_directions_car)
            .into(binding.carIv)
    }

    @SuppressLint("SimpleDateFormat")
    fun convertLongToTime(time: Long): String {
        val time = java.sql.Date(time)
        val format = SimpleDateFormat("HH:mm")
        return format.format(time)
    }
}