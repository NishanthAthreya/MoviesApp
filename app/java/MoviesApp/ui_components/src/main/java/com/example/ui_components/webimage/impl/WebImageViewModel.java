package com.example.ui_components.webimage.impl;

import android.graphics.Bitmap;

import com.example.ui_components.BaseViewModel;
import com.example.ui_components.webimage.model.WebImage;

/**
 * WebImage view model
 */
public class WebImageViewModel extends BaseViewModel<WebImage> {

    /**
     * Returns image.
     */
    public Bitmap image() {
        return model().getImage();
    }

}
