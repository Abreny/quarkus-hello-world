package com.abned.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.MongoEntity;

@MongoEntity(collection = "todos")
public class Todo {
    private ObjectId id;
    private String name;
    private String type;
    private String description;

    @JsonFormat(pattern = "dd-MM-YYYY")
    private Date createdAt;

    @JsonFormat(pattern = "dd-MM-YYYY")
    private Date updatedAt;

    @JsonFormat(pattern = "dd-MM-YYYY")
    private Date estimatedAt;
    private Date endAt;

    public Todo setId(ObjectId id) {
        this.id = id;
        return this;
    }
    
    public ObjectId getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Todo setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return this.type;
    }
    
    public Todo setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Todo setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Todo setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Todo setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Date getEstimatedAt() {
        return estimatedAt;
    }

    public Todo setEstimatedAt(Date estimatedAt) {
        this.estimatedAt = estimatedAt;
        return this;
    }

    public Date getEndAt() {
        return endAt;
    }

    public Todo setEndAt(Date endAt) {
        this.endAt = endAt;
        return this;
    }
}