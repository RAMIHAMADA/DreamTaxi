package com.rami.dreamtaxi.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rami.dreamtaxi.R
import com.rami.dreamtaxi.adapters.OrdersAdapter
import com.rami.dreamtaxi.databinding.FragmentMainScreenOrdersBinding
import com.rami.dreamtaxi.view_models.OrdersViewModel
import com.rami.incredibletaxiorders.MainScreenOrdersFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreenOrdersFragment : Fragment(R.layout.fragment_main_screen_orders) {


    private val ordersViewModel: OrdersViewModel by activityViewModels()
    private val binding: FragmentMainScreenOrdersBinding by viewBinding()

    lateinit var adapter: OrdersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }


    private fun initAdapter() {
        adapter = OrdersAdapter {

            findNavController().navigate(
                MainScreenOrdersFragmentDirections.actionMainScreenOrdersFragmentToOrdersDetailsFragment(
                    ordersViewModel.getOrder(
                        it
                    ) ?: ordersViewModel.ordersItem.value.first()
                )
            )

        }
        binding.recyclerViewMainScreen.adapter = adapter
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewMainScreen.layoutManager = layoutManager
        lifecycleScope.launchWhenResumed {
            ordersViewModel.ordersItem.collect {
                adapter.submitList(it)
            }
        }
    }

    companion object {
        const val TAG = "MainScreenOrdersFragment"
    }

}