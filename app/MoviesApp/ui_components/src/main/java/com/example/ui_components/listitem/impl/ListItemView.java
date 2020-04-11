package com.example.ui_components.listitem.impl;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ui_components.BaseView;
import com.example.ui_components.BaseViewModel;
import com.example.ui_components.R;
import com.example.ui_components.databinding.ViewListItemBinding;
import com.example.ui_components.listitem.ListItemClickHandler;
import com.example.ui_components.listitem.model.ListItem;

/**
 * ListItem view.
 */
public class ListItemView
        extends BaseView<ViewListItemBinding, ListItem, ListItemClickHandler> {

    public ListItemView(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getViewLayout() {
        return R.layout.view_list_item;
    }

    @NonNull
    @Override
    protected BaseViewModel<ListItem> buildViewModel() {
        return new ListItemViewModel();
    }
}
