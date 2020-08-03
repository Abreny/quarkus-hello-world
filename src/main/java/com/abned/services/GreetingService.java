package com.abned.services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greeting(String name) {
        return String.format("Hello %s!", name);
    }
}