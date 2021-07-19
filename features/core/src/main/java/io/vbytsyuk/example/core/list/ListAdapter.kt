package io.vbytsyuk.example.core.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter as RvListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.vbytsyuk.example.core.domain.Item

class ListAdapter<T : Item>(private val params: Params<T>) : RvListAdapter<T, ListAdapter.ViewHolder>(ItemDiffUtil<T>()) {
    data class Params<T>(
        @LayoutRes val layoutId: Int,
        val bindItem: (T, View) -> Unit,
    )

    private class ItemDiffUtil<T : Item> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = oldItem == newItem
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        itemView = LayoutInflater.from(parent.context).inflate(params.layoutId, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        params.bindItem(currentList[position], holder.itemView)
}
