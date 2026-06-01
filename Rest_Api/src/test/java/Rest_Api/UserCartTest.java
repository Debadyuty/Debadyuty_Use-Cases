package Rest_Api;


import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class UserCartTest {

    @Test
    public void getUserCart() {

        given()

        .when()

        .get("https://dummyjson.com/users/6/carts")

        .then()

        .statusCode(200)

        .log().all();

    }
}


