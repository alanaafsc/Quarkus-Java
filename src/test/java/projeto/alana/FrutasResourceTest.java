package projeto.alana;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class FrutasResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/frutas")
          .then()
             .statusCode(200)
             .body(is("[]"));
    }

}