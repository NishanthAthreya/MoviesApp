package com.example.moviesapp.view.screens.componentslist

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.moviesapp.view.components.listitem.ListItemComponentHolder
import com.example.ui_components.listitem.impl.ListItemView

/**
 * Components recyclerview adapter.
 */
internal class ComponentsAdapter: ListAdapter<ListItemComponent, ListItemComponentHolder>(
        object : DiffUtil.ItemCallback<ListItemComponent>() {
            override fun areItemsTheSame(
                    oldItem: ListItemComponent,
                    newItem: ListItemComponent
            ): Boolean {
                return false
            }

            override fun areContentsTheSame(
                    oldItem: ListItemComponent,
                    newItem: ListItemComponent
            ): Boolean {
                return false
            }
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = with(parent) {
        ListItemComponentHolder(
                ListItemView(context)
        )
    }

    override fun onBindViewHolder(holder: ListItemComponentHolder, position: Int) =
            with(getItem(position)) {
                holder.bind(
                        model,
                        handler
                )
            }
}