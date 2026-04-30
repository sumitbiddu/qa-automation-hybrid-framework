package api.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    @Test
    public void getUsersTest() {

        given()
        .when()
            .get("https://jsonplaceholder.typicode.com/users")
        .then()
            .statusCode(200)
            .body("[0].id", notNullValue());
    }
}