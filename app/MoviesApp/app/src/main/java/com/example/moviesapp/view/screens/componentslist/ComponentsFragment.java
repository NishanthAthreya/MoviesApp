package com.example.moviesapp.view.screens.componentslist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.moviesapp.databinding.FragmentComponentsListBinding;
import com.example.moviesapp.view.BaseFragment;
import com.example.moviesapp.view.ScreenView;

/**
 * Components fragment.
 */
public class ComponentsFragment extends BaseFragment<FragmentComponentsListBinding> {
    @Override
    protected FragmentComponentsListBinding binding(LayoutInflater inflater, ViewGroup container) {
        return FragmentComponentsListBinding.inflate(
                inflater,
                container,
                false
        );
    }

    @Override
    protected ScreenView<FragmentComponentsListBinding> view() {
        return new ComponentsView();
    }
}
