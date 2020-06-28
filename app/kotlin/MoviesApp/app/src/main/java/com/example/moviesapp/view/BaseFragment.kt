package com.example.moviesapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding>: Fragment() {

    private var binding: T? = null
    private lateinit var view: ScreenView<T>

    /**
     * Inflates fragment layout.
     *
     * @param inflater inflater
     * @param container container
     *
     * @return fragment layout binding.
     */
    protected abstract fun binding(
            inflater: LayoutInflater,
            container: ViewGroup
    ): T

    /**
     * Returns fragment view.
     */
    protected abstract fun view(): ScreenView<T>

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = binding(
                inflater,
                container!!
        ).also {
            it.lifecycleOwner = this
        }

        return binding!!.root
    }

    override fun onViewCreated(
            view: View,
            savedInstanceState: Bundle?
    ) {
        super.onViewCreated(
                view,
                savedInstanceState
        )
        this.view = view()
        this.view.applyBinding(binding)
    }

    override fun onDestroyView() {
        binding = null
        view.resetBinding()
        super.onDestroyView()
    }
}