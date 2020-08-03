package com.abned.resources;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@QuarkusTest
public class TodoResourceTest {
    final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public String testCreateTodoWithValidData() {
        final String id = given()
            .param("name", "Hello world!")
            .param("type", "quarkus")
            .param("estimated_at", dateFormat.format(Date.from(Instant.now().plusSeconds(2190 * 60 * 60))))
            .param("description", "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Aliquid officiis magni unde natus voluptatum esse provident sequi nobis distinctio molestias eaque, tempore repudiandae asperiores quas reiciendis exercitationem, a ipsum? Dolorum?")
        .when().post("/todos")
        .then()
            .statusCode(200)
            .body("name", equalTo("Hello world!"))
            .body("id", notNullValue())
        .extract()
            .path("id");
        return id;
    }

    public String testDeleteTodoWithValidId() {
        final String id = testCreateTodoWithValidData();
        given()
            .pathParam("id", id)
        .when().delete("/todos/{id}")
        .then()
            .statusCode(200)
            .body("name", notNullValue())
            .body("id", equalTo(id));
        return id;
    }

    @Test
    public void testDeleteTodoWithInvalidId() {
        final String id = "this-id-is-invalid"; // should be hex string
        given()
            .pathParam("id", id)
        .when().delete("/todos/{id}")
        .then()
            .statusCode(400)
            .body("message", notNullValue());
    }

    @Test
    public void testDeleteTodoWithNotFoundId() {
        final String id = testDeleteTodoWithValidId();
        given()
            .pathParam("id", id)
        .when().delete("/todos/{id}")
        .then()
            .statusCode(400)
            .body("message", notNullValue())
            .body("message", containsString(id));
    }
}