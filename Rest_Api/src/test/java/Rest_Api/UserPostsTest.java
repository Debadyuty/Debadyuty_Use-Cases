package Rest_Api;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class UserPostsTest {

    @Test
    public void getUserPosts() {

        given()

        .when()

        .get("https://dummyjson.com/users/5/posts")

        .then()

        .statusCode(200)

        .log().all();

    }
}
