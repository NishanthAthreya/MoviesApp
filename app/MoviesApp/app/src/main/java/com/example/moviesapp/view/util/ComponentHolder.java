package com.example.moviesapp.view.util;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ui_components.BaseView;

/**
 * Component holder for view.
 *
 * @param <T> View binding
 * @param <M> Model
 * @param <H> Handler
 */
public class ComponentHolder<T extends ViewDataBinding, M, H> extends RecyclerView.ViewHolder {

    private final BaseView<T, M, H> view;

    public ComponentHolder(@NonNull BaseView<T, M, H> view) {
        super(view);
        this.view = view;
    }

    /**
     * Binds data to view.
     *
     * @param model model
     * @param handler handler
     */
    public void bind(
            M model,
            H handler
    ) {
        view.setModel(model);
        view.setHandler(handler);
    }
}
