package com.abned.errors;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

@SuppressWarnings("serial")
public class CustomException extends RuntimeException {
    private final String message;

    public CustomException(final String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }
    
    public  int getCode() {
        return Response.Status.BAD_REQUEST.getStatusCode();
    }

    public  Object getBody() {
        final Map<String, Object> body = new HashMap<>();
        body.put("message", getMessage());
        return body;
    }
}