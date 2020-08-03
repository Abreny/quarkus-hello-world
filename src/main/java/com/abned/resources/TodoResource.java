package com.abned.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.abned.entities.Todo;
import com.abned.forms.TodoForm;
import com.abned.repositories.TodoRepository;

import org.jboss.resteasy.annotations.Form;

@Produces(MediaType.APPLICATION_JSON)
@Path("/todos")
public class TodoResource {

    @Inject
    TodoRepository todos;
    
    @POST
    public Todo createTodo(@Form TodoForm form) {
        return todos.create(form);
    }

    @PUT
    @Path("{todoId}")
    public Todo updateTodo(@Form TodoForm form, @PathParam("todoId") String id) {
        return todos.update(form, id);
    }

    @GET
    public List<Todo> allTodos() {
        return todos.findAll().list();
    }

    @DELETE
    @Path("{todoId}")
    public Todo deleteTodo(@PathParam("todoId") String todoId) {
        return todos.delete(todoId);
    }
}