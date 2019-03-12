package com.example.todo;


import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class TodoUI extends UI {

    private VerticalLayout layout;

    @Autowired
    TodoList todoList;

    @Override
    protected void init(VaadinRequest request) {
        setupLayout();
        addHeader();
        addForm();
        addTodoList();
        addActionButton();
    }

    private void setupLayout() {
        layout = new VerticalLayout();
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(layout);
    }

    private void addHeader() {
        Label header = new Label("TODOs");
        header.addStyleName(ValoTheme.LABEL_H1);
        header.setSizeUndefined();
        layout.addComponent(header);
    }

    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setSpacing(true);
        formLayout.setWidth("80%");

        TextField taskField = new TextField();
        taskField.setWidth("100%");

        new Binder<Todo>().forField(taskField)
                .withValidator(str -> str.length() > 5, "Must be more than 4 chars")
                .withValidator(str -> str.length() < 15, "Too big!")
                .bind(Todo::getText, Todo::setText);

        Button addButton = new Button("");
        addButton.setIcon(VaadinIcons.PLUS);
        addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

        formLayout.addComponentsAndExpand(taskField);
        formLayout.addComponents(addButton);

        addButton.addClickListener(clickEvent -> {
            todoList.add(new Todo(taskField.getValue()));
            Notification.show(taskField.getValue()+" added successfully!");
            taskField.clear();
            taskField.focus();
        });
        taskField.focus();
        addButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        layout.addComponent(formLayout);
    }

    private void addTodoList() {
        todoList.setWidth("80%");
        layout.addComponent(todoList);
    }

    private void addActionButton() {
        Button deleteButton = new Button("Delete Completed", clickEvent -> {
            todoList.deleteCompleted();
        });
        layout.addComponent(deleteButton);
    }
}
