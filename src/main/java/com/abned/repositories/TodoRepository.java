package com.abned.repositories;

import javax.enterprise.context.ApplicationScoped;

import com.abned.entities.Todo;
import com.abned.errors.CustomException;
import com.abned.forms.TodoForm;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class TodoRepository implements PanacheMongoRepository<Todo> {
    public Todo findById(String id) {
        try {
            Todo todo = null;
            if ((todo = findById(new ObjectId(id))) != null) {
                return todo;
            }
            throw new CustomException(String.format("Todo is %s not found", id));
        } catch(IllegalArgumentException e) {
            throw new CustomException("Invalid todo id string value");
        }
    }

    public Todo create(TodoForm form) {
        final Todo todo = form.todo(null);
        persist(todo);
        return todo;
    }

    public Todo update(TodoForm form, String id) {
        final Todo todo = form.todo(findById(id));
        update(todo);
        return todo;
    }
    public Todo delete(String id) {
        final Todo todo = findById(id);
        delete(todo);
        return todo;
    }
}