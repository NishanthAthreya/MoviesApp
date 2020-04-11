package com.example.ui_components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseView<T extends ViewDataBinding, M, H> extends FrameLayout {

    private T viewDataBinding;
    private BaseViewModel<M> viewModel;

    public BaseView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public BaseView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(
                context,
                attrs
        );
        init(context);
    }

    /**
     * Initializes view
     * @param context context
     */
    private void init(@NonNull Context context) {
        if(!isInEditMode()) {
            viewDataBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(context),
                    getViewLayout(),
                    this,
                    true
            );
        }

        viewModel = buildViewModel();
    }

    /**
     * Returns layout id for inflating view.
     *
     * @return layout id connected to custom view
     */
    @LayoutRes
    protected abstract int getViewLayout();

    /**
     * Returns view data binding.
     */
    protected T getViewDataBinding() {
        return viewDataBinding;
    }

    /**
     * Sets model
     *
     * @param model model
     */
    public void setModel(@NonNull M model) {
        viewModel.setModel(model);
        viewDataBinding.setVariable(
                BR.viewModel,
                viewModel
        );
    }

    /**
     * Sets handler.
     *
     * @param handler handler
     */
    public void setHandler(@NonNull H handler) {
        viewDataBinding.setVariable(
                BR.handler,
                handler
        );
    }

    /**
     * Returns view model.
     */
    @NonNull
    protected abstract BaseViewModel<M> buildViewModel();
}
