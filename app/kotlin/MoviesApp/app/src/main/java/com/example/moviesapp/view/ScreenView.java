package com.example.moviesapp.view;

import androidx.databinding.ViewDataBinding;

/**
 * Screen view contract.
 *
 * @param <T> View binding
 */
public interface ScreenView<T extends ViewDataBinding> {

    /**
     * Applies binding.
     *
     * @param binding view binding
     */
    void applyBinding(T binding);

    /**
     * Resets binding.
     */
    void resetBinding();
}
