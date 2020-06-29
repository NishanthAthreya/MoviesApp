package com.example.moviesapp.navigation

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.moviesapp.R
import com.example.moviesapp.view.BaseFragment

/**
 * Fragment with navigation capability.
 *
 * @param <T> View binding
 */
internal abstract class NavigationFragment<T: ViewDataBinding>: BaseFragment<T>() {

    protected fun navigateTo(
            bundle: Bundle,
            fragment: Fragment
    ) {
        fragment.arguments = bundle
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(
                R.id.fragmentContainer,
                fragment
        )
        transaction.commit()
    }
}