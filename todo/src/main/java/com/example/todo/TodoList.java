package com.example.todo;

import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class TodoList extends VerticalLayout {

    @Autowired
    TodoRepository todoRepository;

    @PostConstruct
    void init(){
        setSpacing(true);
        update();
    }

    private void update() {
        setTodos(todoRepository.findAll());
    }

    private void setTodos(List<Todo> todos) {
        removeAllComponents();
        todos.forEach(todo -> {
            addComponent(new TodoLayout(todo));
        });
    }
    public void add(Todo todo){
        todoRepository.save(todo);
        update();
    }

    public void deleteCompleted() {
        todoRepository.deleteByDone(true);
        update();
    }
}
