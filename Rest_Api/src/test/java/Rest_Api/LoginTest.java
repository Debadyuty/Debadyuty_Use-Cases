package Rest_Api;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void loginUser() {

        String token = given()

        .header("Content-Type", "application/json")

        .body("{\r\n"
                + "    \"username\": \"emilys\",\r\n"
                + "    \"password\": \"emilyspass\",\r\n"
                + "    \"expiresInMins\": 30\r\n"
                + "}")

        .when()

        .post("https://dummyjson.com/user/login")

        .then()

        .statusCode(200)

        .extract()
        .path("accessToken");



        System.out.println("Generated Token: " + token);



        // Step 2: Access secured API using token

        given()

        .header("Authorization", "Bearer " + token)

        .when()

        .get("https://dummyjson.com/user/me")

        .then()

        .statusCode(200)

        .log().all();

    }
}