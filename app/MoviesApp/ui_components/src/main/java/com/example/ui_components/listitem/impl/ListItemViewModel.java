package com.example.ui_components.listitem.impl;

import com.example.ui_components.BaseViewModel;
import com.example.ui_components.listitem.model.ListItem;

/**
 * ListItem view model.
 */
public class ListItemViewModel extends BaseViewModel<ListItem> {

    /**
     * Returns label.
     */
    public CharSequence label() {
        return model().label();
    }
}
