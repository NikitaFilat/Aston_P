import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers", notNullValue())
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void testPostRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .body(requestBody)
                .contentType("text/plain")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("args", equalTo(new HashMap<>()))
                .body("files", equalTo(new HashMap<>()))
                .body("form", equalTo(new HashMap<>()))
                .body("json", nullValue());
    }

    @Test
    public void testPostFormData() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("args", equalTo(new HashMap<>()))
                .body("data", equalTo(""))
                .body("files", equalTo(new HashMap<>()));
    }

    @Test
    public void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .body(requestBody)
                .contentType("text/plain")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("args", equalTo(new HashMap<>()))
                .body("files", equalTo(new HashMap<>()))
                .body("form", equalTo(new HashMap<>()))
                .body("json", nullValue());
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .body(requestBody)
                .contentType("text/plain")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("args", equalTo(new HashMap<>()))
                .body("files", equalTo(new HashMap<>()))
                .body("form", equalTo(new HashMap<>()))
                .body("json", nullValue());
    }

    @Test
    public void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .body(requestBody)
                .contentType("text/plain")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("args", equalTo(new HashMap<>()))
                .body("files", equalTo(new HashMap<>()))
                .body("form", equalTo(new HashMap<>()))
                .body("json", nullValue());
    }
}