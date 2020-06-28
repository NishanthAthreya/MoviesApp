package com.example.ui_components;

import androidx.annotation.NonNull;

/**
 * Base component view model.
 *
 * @param <M> Model
 */
public class BaseViewModel<M> {

    private M model;

    /**
     * Sets model to view model.
     *
     * @param model model
     */
    public void setModel(@NonNull M model) {
        this.model = model;
    }

    @NonNull
    protected M model() {
        if(model == null) {
            throw new IllegalStateException("Model not set");
        }

        return model;
    }
}
