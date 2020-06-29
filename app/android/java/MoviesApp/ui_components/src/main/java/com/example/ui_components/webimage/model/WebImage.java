package com.example.ui_components.webimage.model;

import android.graphics.Bitmap;

/**
 * WebImage presentation model.
 */
public class WebImage {

    private final Bitmap image;

    public WebImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }
}
