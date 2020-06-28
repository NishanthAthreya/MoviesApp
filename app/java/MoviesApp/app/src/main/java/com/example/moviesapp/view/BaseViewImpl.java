package com.example.moviesapp.view;

import androidx.databinding.ViewDataBinding;

/**
 * Base view implementation.
 *
 * @param <T> View binding
 */
public abstract class BaseViewImpl<T extends ViewDataBinding>
        implements ScreenView<T> {

    private T binding;

    @Override
    public void applyBinding(T binding) {
        this.binding = binding;
        setBinding(binding);
    }

    @Override
    public void resetBinding() {
        clearBinding();
        binding = null;
    }

    /**
     * Returns binding.
     */
    protected final T binding() {
        return binding;
    }

    /**
     * Sets binding.
     *
     * @param binding view binding
     */
    protected abstract void setBinding(T binding);

    /**
     * Clears binding.
     */
    protected abstract void clearBinding();
}
