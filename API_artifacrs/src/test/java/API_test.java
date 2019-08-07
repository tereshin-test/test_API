import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.*;
import com.google.gson.Gson;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class API_test {
    @Test()
    public void test_Content() {
        UUID uuid = UUID.randomUUID();
        Task new_task = new Task("test123");
        Gson gson = new Gson();
        String data = gson.toJson(new_task);
        Response response_1 = given()
                .auth().oauth2("ca11b94cb630fb78a4ad9ea6535e7bc079cf8c67")
                .header("X-Request-Id", uuid)
                .contentType("application/json")
                .accept("application/json")
                .body(data)
                .log().all()
                .when()
                .post("https://beta.todoist.com/API/v8/tasks")
                .then()
                .log().all()
                .statusCode(200)
                .body("content", equalTo("test123"))
                .extract()
                .response();
        response_1.getBody().print();

    }
}
