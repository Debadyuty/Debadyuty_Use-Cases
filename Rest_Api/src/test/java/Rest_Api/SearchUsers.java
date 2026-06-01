package Rest_Api;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class SearchUsers {

    @Test
    public void searchUser() {

        given()

        .queryParam("q", "John")

        .when()

        .get("https://dummyjson.com/users/search")

        .then()

        .statusCode(200)

        .log().all();

    }
}