package com.rami.dreamtaxi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rami.dreamtaxi.databinding.ItemOrderBinding
import com.rami.dreamtaxi.models.OrderItem

class OrdersAdapter(private val listener: (Int) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<OrderItem, OrdersAdapter.OrderViewHolder>(
        OrderDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemOrderBinding.inflate(inflater, parent, false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = getItem(position)
        holder.itemView.setOnClickListener {
            listener(order.id)
        }
        holder.bind(order)
    }

    inner class OrderViewHolder(private val binding: ItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(orderItem: OrderItem) = binding.apply {
            cost.text = orderItem.price
            date.text = orderItem.orderTime
            startAdress.text = orderItem.startAddress
            endAdress.text = orderItem.endAddress
        }
    }

    class OrderDiffCallback : DiffUtil.ItemCallback<OrderItem>() {
        override fun areItemsTheSame(oldItem: OrderItem, newItem: OrderItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: OrderItem, newItem: OrderItem): Boolean {
            return oldItem == newItem
        }
    }
}