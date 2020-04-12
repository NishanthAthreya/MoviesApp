package com.example.ui_components.listitem.impl;

import com.example.ui_components.listitem.model.ListItem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListItemViewModelTest {

    private ListItemViewModel classUnderTest;

    @Before
    public void setup() {
        classUnderTest = new ListItemViewModel();
    }

    @Test
    public void label() {
        CharSequence label = "label";
        ListItem listItem = mock(ListItem.class);

        when(listItem.label()).thenReturn(label);

        classUnderTest.setModel(listItem);
        
        CharSequence result = classUnderTest.label();

        assertEquals(
                label,
                result
        );

        verify(listItem).label();
    }
}
