package io.vbytsyuk.example.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter as RvListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.vbytsyuk.example.core.domain.Item

class ListAdapter<T : Item>(
    @LayoutRes private val layoutId: Int,
    private val bindItem: (T, View) -> Unit,
) : RvListAdapter<T, ListAdapter.ViewHolder>(ItemDiffUtil<T>()) {
    private class ItemDiffUtil<T : Item> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = oldItem == newItem
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        itemView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        bindItem(currentList[position], holder.itemView)
}