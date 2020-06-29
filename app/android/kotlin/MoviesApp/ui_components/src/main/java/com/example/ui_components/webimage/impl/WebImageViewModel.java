package com.example.ui_components.webimage.impl;

import com.example.ui_components.BaseViewModel;
import com.example.ui_components.webimage.model.WebImage;

/**
 * WebImage view model
 */
public class WebImageViewModel extends BaseViewModel<WebImage> {

    public String url() {
        return model().url();
    }

}
