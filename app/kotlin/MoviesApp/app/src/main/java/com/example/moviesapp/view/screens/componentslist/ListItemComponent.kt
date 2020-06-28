package com.example.moviesapp.view.screens.componentslist

import com.example.ui_components.listitem.ListItemClickHandler
import com.example.ui_components.listitem.model.ListItem

internal data class ListItemComponent(
        val model: ListItem,
        val handler: ListItemClickHandler
)