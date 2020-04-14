package com.example.moviesapp.navigation;

import android.os.Bundle;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.moviesapp.R;
import com.example.moviesapp.view.BaseFragment;

/**
 * Fragment with navigation capability.
 *
 * @param <T> View binding
 */
public abstract class NavigationFragment<T extends ViewDataBinding>
        extends BaseFragment<T> {

    protected void navigateTo(
            Bundle bundle,
            Fragment fragment
    ) {
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(
                R.id.fragmentContainer,
                fragment
        );
        transaction.commit();
    }
}
