package com.example.moviesapp.view.components.listitem;

import androidx.annotation.NonNull;

import com.example.moviesapp.view.util.ComponentHolder;
import com.example.ui_components.BaseView;
import com.example.ui_components.databinding.ViewListItemBinding;
import com.example.ui_components.listitem.ListItemClickHandler;
import com.example.ui_components.listitem.model.ListItem;

/**
 * List item component holder.
 */
public class ListItemComponentHolder
        extends ComponentHolder<ViewListItemBinding, ListItem, ListItemClickHandler> {

    public ListItemComponentHolder(
            @NonNull BaseView<ViewListItemBinding, ListItem, ListItemClickHandler> view
    ) {
        super(view);
    }
}
