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

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ComponentsView extends BaseViewImpl<FragmentComponentsListBinding> {

    private final MoviesRepo moviesRepo;
    private final CompositeDisposable compositeDisposable;

    ComponentsView() {
        moviesRepo = new MoviesRepo();
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void setBinding(FragmentComponentsListBinding binding) {
        ListAdapter<ListItem, ListItemComponentHolder> adapter = new ComponentsAdapter();
        binding.container.setAdapter(adapter);
        compositeDisposable.add(
                moviesRepo.movies()
                        .map(this::convertToListItems)
                        .subscribe(adapter::submitList)
        );
    }

    private List<ListItem> convertToListItems(List<Movie> movies) {
        return movies.stream()
                .map(movie -> new ListItem(movie.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    protected void clearBinding() {
        compositeDisposable.clear();
    }
}
