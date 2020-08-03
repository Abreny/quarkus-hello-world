package com.abned.errors;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ErrorMapping implements ExceptionMapper<CustomException> {

    @Override
    public Response toResponse(CustomException exception) {
        return Response.status(exception.getCode())
            .entity(exception.getBody())
            .type(MediaType.APPLICATION_JSON)
            .build();
    }
}