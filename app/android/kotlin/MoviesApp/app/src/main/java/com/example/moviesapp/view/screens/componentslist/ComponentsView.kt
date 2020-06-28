package com.example.moviesapp.view.screens.componentslist

import com.example.moviesapp.data.movies.impl.MoviesRepo
import com.example.moviesapp.data.movies.model.Movie
import com.example.moviesapp.databinding.FragmentComponentsListBinding
import com.example.moviesapp.view.BaseViewImpl
import com.example.ui_components.listitem.ListItemClickHandler
import com.example.ui_components.listitem.model.ListItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

internal class ComponentsView(private val componentsNavigator: (Movie) -> Unit):
        BaseViewImpl<FragmentComponentsListBinding>() {

    private val moviesRepo = MoviesRepo()
    private val compositeDisposable = CompositeDisposable()

    override fun setBinding(binding: FragmentComponentsListBinding){
        val adapter = ComponentsAdapter()
        binding.container.adapter = adapter
        compositeDisposable.add(
                moviesRepo.movies()
                        .map(::convertToListItems)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(adapter::submitList)
        )
        binding.executePendingBindings()
    }

    private fun convertToListItems(movies: List<Movie>) = movies.map {
        ListItemComponent(
                model = ListItem(it.title),
                handler = ListItemClickHandler { componentsNavigator(it) }
        )
    }

    override fun clearBinding() {
        compositeDisposable.clear()
    }
}