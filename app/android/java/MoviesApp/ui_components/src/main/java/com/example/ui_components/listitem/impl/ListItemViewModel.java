package com.example.ui_components.listitem.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.ui_components.BaseViewModel;
import com.example.ui_components.listitem.model.ListItem;
import com.example.ui_components.webimage.model.WebImage;

import java.io.InputStream;
import java.net.URL;

/**
 * ListItem view model.
 */
public class ListItemViewModel extends BaseViewModel<ListItem> {

    /**
     * Returns label.
     */
    public CharSequence label() {
        return model().label();
    }
}
