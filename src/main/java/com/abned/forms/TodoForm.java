package com.abned.forms;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.ws.rs.FormParam;

import com.abned.entities.Todo;
import com.abned.forms.annotations.DateFormat;

public class TodoForm {

    @FormParam("name")
    private String name;

    @FormParam("type")
    private String type;

    @FormParam("description")
    private String description;

    @JsonbDateFormat("dd-MM-yyyy")
    @FormParam("estimated_at")
    @DateFormat("dd-MM-yyyy")
    private LocalDate estimatedAt;

    public String getName() {
        return name;
    }

    public TodoForm setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public TodoForm setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TodoForm setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getEstimatedAt() {
        return estimatedAt;
    }

    public TodoForm setEstimatedAt(LocalDate estimatedAt) {
        this.estimatedAt = estimatedAt;
        return this;
    }

    /**
     * Populate the todo in params with the value of this form data
     * @param todo  The todo to populated
     * @return com.abned.entities.Todo The todo populated
     */
    public Todo todo(Todo todo) {
        final Date now = new Date();
        if (todo == null) {
            todo = new Todo().setCreatedAt(now);
        }
        if (name != null) {
            todo.setName(name);
        }
        if (type != null) {
            todo.setType(type);
        }
        if (estimatedAt != null) {
            todo.setEstimatedAt(Date.from(estimatedAt.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }
        if (description != null) {
            todo.setDescription(description);
        }
        return todo.setUpdatedAt(now);
    }
}