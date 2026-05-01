package api.tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    @Test
    public void getUsersTest() {

        given()
            .baseUri("https://jsonplaceholder.typicode.com")
            .log().all()

        .when()
            .get("/users")

        .then()
            .log().all()
            .statusCode(200)
            .body("size()", greaterThan(0))
            .body("[0].id", notNullValue())
            .body("[0].email", containsString("@"));
    }

    @Test
    public void createUserTest() {

        given()
            .baseUri("https://jsonplaceholder.typicode.com")
            .contentType(ContentType.JSON)
            .body("{ \"name\": \"Sumit\", \"job\": \"QA\" }")

        .when()
            .post("/users")

        .then()
            .statusCode(201)
            .body("name", equalTo("Sumit"));
    }
}