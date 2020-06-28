package com.example.moviesapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {

    private T binding;
    private ScreenView<T> view;

    public BaseFragment() {
    }

    /**
     * Inflates fragment layout.
     *
     * @param inflater inflater
     * @param container container
     *
     * @return fragment layout binding.
     */
    protected abstract T binding(
            LayoutInflater inflater,
            ViewGroup container
    );

    /**
     * Returns fragment view.
     */
    protected abstract ScreenView<T> view();

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        binding = binding(
                inflater,
                container
        );
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState
    ) {
        super.onViewCreated(
                view,
                savedInstanceState
        );
        this.view = view();
        this.view.applyBinding(binding);
    }

    @Override
    public void onDestroyView() {
        binding = null;
        view.resetBinding();
        super.onDestroyView();
    }
}
