package com.example.todo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String text;

    private boolean done;

    public Todo() {
    }

    public Todo(String text) {
        this.text = text;
    }

    public Todo(String text, boolean done) {
        this.text = text;
        this.done = done;
    }
}