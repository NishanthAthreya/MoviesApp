package com.example.moviesapp.view.screens.componentslist;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.moviesapp.view.components.listitem.ListItemComponentHolder;
import com.example.ui_components.listitem.impl.ListItemView;

/**
 * Components recyclerview adapter.
 */
public class ComponentsAdapter extends ListAdapter<ListItemComponent, ListItemComponentHolder> {

    ComponentsAdapter() {
        this(new DiffUtil.ItemCallback<ListItemComponent>() {
            @Override
            public boolean areItemsTheSame(
                    @NonNull ListItemComponent oldItem,
                    @NonNull ListItemComponent newItem
            ) {
                return false;
            }

            @Override
            public boolean areContentsTheSame(
                    @NonNull ListItemComponent oldItem,
                    @NonNull ListItemComponent newItem
            ) {
                return false;
            }
        });
    }

    private ComponentsAdapter(@NonNull DiffUtil.ItemCallback<ListItemComponent> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ListItemComponentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemView listItemView = new ListItemView(parent.getContext());

        return new ListItemComponentHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemComponentHolder holder, int position) {
        holder.bind(
                getItem(position).getModel(),
                getItem(position).getHandler()
        );
    }
}
