package com.example.ui_components.webimage.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.ui_components.BaseView;
import com.example.ui_components.BaseViewModel;
import com.example.ui_components.R;
import com.example.ui_components.databinding.ViewWebImageBinding;
import com.example.ui_components.webimage.model.WebImage;

public class WebImageView extends BaseView<ViewWebImageBinding, WebImage, Void> {

    public WebImageView(@NonNull Context context) {
        super(context);
    }

    public WebImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getViewLayout() {
        return R.layout.view_web_image;
    }

    @BindingAdapter("webImage")
    public static void setWebImage(
            ImageView webImageView,
            String url
    ) {
        Glide.with(webImageView.getContext()).
                load(url)
                .into(webImageView);
    }

    @NonNull
    @Override
    protected BaseViewModel<WebImage> buildViewModel() {
        return new WebImageViewModel();
    }
}
