package Rest_Api;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetAllUsers {

    @Test
    public void getUsers() {

        given()

        .when()
            .get("https://dummyjson.com/users")

        .then()
            .statusCode(200)
            .log().all();

    }
}