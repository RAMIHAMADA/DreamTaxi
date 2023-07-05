package com.rami.dreamtaxi.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.ImageLoader
import coil.load
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.signature.ObjectKey
import com.rami.dreamtaxi.R
import com.rami.dreamtaxi.databinding.FragmentDetalisOrderBinding
import kotlinx.coroutines.launch
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
        val photoUrl = "https://www.roxiemobile.ru/careers/test/images/${args.order.vehicle.photo}"

        Glide.with(requireContext())
            .load(photoUrl)
            .placeholder(R.drawable.baseline_directions_car)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .signature(ObjectKey(System.currentTimeMillis().toString())) // Изменяем подпись для обновления кеша при каждой загрузке
            .override(com.bumptech.glide.request.target.Target.SIZE_ORIGINAL) // Используем оригинальный размер изображения
            .transition(DrawableTransitionOptions.withCrossFade()) // Анимация перехода
            .into(binding.carIv)
    }


    @SuppressLint("SimpleDateFormat")
    fun convertLongToTime(time: Long): String {
        val time = java.sql.Date(time)
        val format = SimpleDateFormat("HH:mm")
        return format.format(time)
    }
}