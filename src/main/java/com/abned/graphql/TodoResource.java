package com.abned.graphql;

import java.util.List;

import javax.inject.Inject;

import com.abned.entities.Todo;
import com.abned.forms.TodoForm;
import com.abned.repositories.TodoRepository;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class TodoResource {

    @Inject
    TodoRepository todos;

    @Query("todos")
    @Description("Get all todo form database.")
    public List<Todo> getAlTodos() {
        return todos.findAll().list();
    }

    @Query("todo")
    @Description("Get todo by id.")
    public Todo getTodo(@Name("todoId") String id) {
        return todos.findById(id);
    }

    @Mutation("createTodo")
    @Description("Create and saved a Todo.")
    public Todo createTodo(@Name("todo") TodoForm form) {
        return todos.create(form);
    }

    @Mutation("deleteTodo")
    @Description("Delete a Todo by id.")
    public Todo deleteTodo(@Name("todoId") String id) {
        return todos.delete(id);
    }

    @Mutation("updateTodo")
    @Description("Update a Todo by id.")
    public Todo updateTodo(@Name("todoId") String id, @Name("todo") TodoForm form) {
        return todos.update(form, id);
    }
}