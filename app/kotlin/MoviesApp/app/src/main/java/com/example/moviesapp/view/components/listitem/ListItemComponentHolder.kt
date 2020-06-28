package com.example.moviesapp.view.components.listitem

import com.example.moviesapp.view.util.ComponentHolder
import com.example.ui_components.BaseView
import com.example.ui_components.databinding.ViewListItemBinding
import com.example.ui_components.listitem.ListItemClickHandler
import com.example.ui_components.listitem.model.ListItem

/**
 * List item component holder.
 */
internal class ListItemComponentHolder(
        view: BaseView<ViewListItemBinding,
                ListItem,
                ListItemClickHandler>
) : ComponentHolder<ViewListItemBinding, ListItem, ListItemClickHandler>(
        view
)