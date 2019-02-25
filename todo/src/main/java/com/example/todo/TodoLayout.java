package com.example.todo;

import com.vaadin.data.Binder;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class TodoLayout extends HorizontalLayout {
    private final CheckBox done;
    private final TextField text;
    public TodoLayout(Todo todo) {
        setSpacing(true);
        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        done = new CheckBox();
        text = new TextField();
        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);

        addComponents(done);
        addComponentsAndExpand(text);
        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        Binder<Todo> todoBinder = new Binder<>(Todo.class);
        todoBinder.bindInstanceFields(this);
        todoBinder.setBean(todo);
    }
}
