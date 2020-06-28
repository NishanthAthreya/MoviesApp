package com.example.moviesapp.view.screens.componentslist;

import com.example.ui_components.listitem.ListItemClickHandler;
import com.example.ui_components.listitem.model.ListItem;

public class ListItemComponent {

    private final ListItem model;
    private final ListItemClickHandler handler;

    public ListItemComponent(
            ListItem model,
            ListItemClickHandler handler
    ) {
        this.model = model;
        this.handler = handler;
    }

    public ListItem getModel() {
        return model;
    }

    public ListItemClickHandler getHandler() {
        return handler;
    }
}
