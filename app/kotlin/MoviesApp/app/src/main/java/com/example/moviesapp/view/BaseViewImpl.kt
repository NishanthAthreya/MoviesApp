package com.example.moviesapp.view

import androidx.databinding.ViewDataBinding

/**
 * Base view implementation.
 *
 * @param <T> View binding
 */
abstract class BaseViewImpl<T : ViewDataBinding> : ScreenView<T> {

    private var binding: T? = null

    override fun applyBinding(binding: T) {
        this.binding = binding
        setBinding(binding)
    }

    override fun resetBinding() {
        clearBinding()
        binding = null
    }

    /**
     * Returns binding.
     */
    protected fun binding(): T? {
        return binding
    }

    /**
     * Sets binding.
     *
     * @param binding view binding
     */
    protected abstract fun setBinding(binding: T)

    /**
     * Clears binding.
     */
    protected abstract fun clearBinding()
}