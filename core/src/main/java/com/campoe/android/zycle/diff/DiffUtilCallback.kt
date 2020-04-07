package com.campoe.android.zycle.diff

import androidx.recyclerview.widget.DiffUtil
import com.campoe.android.zycle.ktx.cast

typealias ItemComparator<E> = (oldItem: E, newItem: E) -> Boolean

class DiffUtilCallback<E : Any>(
    private val oldItems: List<E>,
    private val newItems: List<E>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return oldItem.cast<Diffable<E>>()?.areItemsTheSame(newItem)
                ?: newItem.cast<Diffable<E>>()?.areItemsTheSame(oldItem)
                ?: oldItem == newItem
    }

    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return oldItem.cast<Diffable<E>>()?.areItemsTheSame(newItem)
                ?: newItem.cast<Diffable<E>>()?.areItemsTheSame(oldItem)
                ?: oldItem == newItem
    }

}