package com.abned.entities;

import java.util.Date;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.MongoEntity;

@MongoEntity(collection = "tasks")
public class Task {
    private ObjectId id;
    private String name;
    private String priority;
    private Date createdAt;
    private Date endAt;
    private TaskStatus taskStatus;
    
    public static enum TaskStatus {
        CREATED,
        STARTED,
        PENDED,
        FINISHED
    }

    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    public String getPriority() {
        return priority;
    }

    public Task setPriority(String priority) {
        this.priority = priority;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Task setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getEndAt() {
        return endAt;
    }

    public Task setEndAt(Date endAt) {
        this.endAt = endAt;
        return this;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public Task setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
        return this;
    }

    public ObjectId getId() {
        return this.id;
    }
}