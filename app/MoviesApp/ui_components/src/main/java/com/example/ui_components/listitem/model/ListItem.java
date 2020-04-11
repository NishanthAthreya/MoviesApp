package com.example.ui_components.listitem.model;

/**
 * ListItem presentation model.
 */
public class ListItem {

    private final CharSequence label;

    public ListItem(CharSequence label) {
        this.label = label;
    }

    /**
     * Returns label.
     */
    public CharSequence label() {
        return label;
    }
}
