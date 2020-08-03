package com.abned.repositories;

import javax.enterprise.context.ApplicationScoped;

import com.abned.entities.Task;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class TaskRepository implements PanacheMongoRepository<Task> {
    
}