package com.example.moviesapp.view.util

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ui_components.BaseView

/**
 * Component holder for view.
 *
 * @param <T> View binding
 * @param <M> Model
 * @param <H> Handler
 */
internal open class ComponentHolder<T: ViewDataBinding, M, H>(val view: BaseView<T, M, H>) :
        ViewHolder(view) {

    /**
     * Binds data to view.
     *
     * @param model model
     * @param handler handler
     */
    fun bind(
            model: M,
            handler: H
    ) {
        view.setModel(model)
        view.setHandler(handler)
    }
}