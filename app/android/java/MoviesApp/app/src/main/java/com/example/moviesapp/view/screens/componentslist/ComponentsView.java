package com.example.moviesapp.view.screens.componentslist;

import androidx.recyclerview.widget.ListAdapter;

import com.example.moviesapp.data.movies.impl.MoviesRepo;
import com.example.moviesapp.data.movies.model.Movie;
import com.example.moviesapp.databinding.FragmentComponentsListBinding;
import com.example.moviesapp.view.BaseViewImpl;
import com.example.moviesapp.view.components.listitem.ListItemComponentHolder;
import com.example.ui_components.listitem.model.ListItem;

import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class ComponentsView extends BaseViewImpl<FragmentComponentsListBinding> {

    private final MoviesRepo moviesRepo;
    private final CompositeDisposable compositeDisposable;
    private final ComponentsFragment.ComponentsNavigator componentsNavigator;

    ComponentsView(ComponentsFragment.ComponentsNavigator componentsNavigator) {
        moviesRepo = new MoviesRepo();
        compositeDisposable = new CompositeDisposable();
        this.componentsNavigator = componentsNavigator;
    }

    @Override
    protected void setBinding(FragmentComponentsListBinding binding) {
        ListAdapter<ListItemComponent, ListItemComponentHolder> adapter = new ComponentsAdapter();
        binding.container.setAdapter(adapter);
        compositeDisposable.add(
                moviesRepo.movies()
                        .map(this::convertToListItems)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(adapter::submitList)
        );
        binding.executePendingBindings();
    }

    private List<ListItemComponent> convertToListItems(List<Movie> movies) {
        return movies.stream()
                .map(movie -> new ListItemComponent(
                        new ListItem(movie.getTitle()),
                        () -> componentsNavigator.openMovieDetails(movie))
                ).collect(Collectors.toList());
    }

    @Override
    protected void clearBinding() {
        compositeDisposable.clear();
    }
}
