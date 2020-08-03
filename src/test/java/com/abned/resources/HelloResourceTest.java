package com.abned.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class HelloResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body("msg", equalTo("Hello World!"));
    }

    @Test
    public void testPostHelloEndpoint() {
        final String name = "Rakoto";
        given()
            .param("name", name)
          .when().post("/hello")
          .then()
             .statusCode(200)
             .body("msg", equalTo("Hello Rakoto!"));
    }
    @Test
    public void testHelloNameEndpoint() {
        given()
          .pathParam("name", "Abned")
          .when().get("/hello/{name}")
          .then()
             .statusCode(200)
             .body("msg", equalTo("Hello Abned!"));
    }
}