package com.example.todo;


import com.vaadin.annotations.Theme;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import javafx.scene.input.KeyCode;
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

        TextField taskfield = new TextField();
        taskfield.setWidth("100%");
        Button addButton = new Button("");
        addButton.setIcon(VaadinIcons.PLUS);
        addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

        formLayout.addComponentsAndExpand(taskfield);
        formLayout.addComponents(addButton);

        addButton.addClickListener(clickEvent -> {
            todoList.add(new Todo(taskfield.getValue()));
            Notification.show(taskfield.getValue()+" added successfully!");
            taskfield.clear();
            taskfield.focus();
        });
        taskfield.focus();
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
