package com.campoe.android.zycle.mapper

import androidx.annotation.LayoutRes
import com.campoe.android.zycle.`typealias`.BinderBuilderBlock
import com.campoe.android.zycle.binder.RecyclerBinder
import com.campoe.android.zycle.util.Builder

internal interface IMapper<E : Any> {

    fun <T : E> getBinder(clazz: Class<T>): RecyclerBinder<E>

    fun hasStableIds(): Boolean

    interface IBuilder<E : Any> : Builder<Mapper<E>> {

        fun <T : E> map(clazz: Class<T>, binder: RecyclerBinder<T>): Mapper.Builder<E>

        fun <T : E> map(
            clazz: Class<T>,
            @LayoutRes layoutRes: Int,
            block: BinderBuilderBlock<T>? = null
        ): Mapper.Builder<E>

        fun <T : E> map(
            clazz: Class<T>,
            @LayoutRes layoutRes: Int,
            viewType: Int,
            block: BinderBuilderBlock<T>? = null
        ): Mapper.Builder<E>

        override fun build(): Mapper<E> {
            TODO("Not yet implemented")
        }

    }

}