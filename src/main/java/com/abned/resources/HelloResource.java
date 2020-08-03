package com.abned.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.abned.entities.Hello;
import com.abned.forms.HelloForm;
import com.abned.services.GreetingService;

import org.jboss.resteasy.annotations.Form;

@Produces(MediaType.APPLICATION_JSON)
@Path("/hello")
public class HelloResource {

    @Inject
    GreetingService greeting;

    @GET
    public Hello hello() {
        return new Hello().setMsg(greeting.greeting("World"));
    }

    @GET
    @Path("/{name}")
    public Hello hello(@PathParam("name") String name) {
        return new Hello().setMsg(greeting.greeting(name));
    }

    @POST
    public Hello helloPost(@Form HelloForm hello) {
        return new Hello().setMsg(greeting.greeting(hello.getName()));
    }
}