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
             .body(is("[{\"id\":1,\"nome\":\"Laranja\",\"qtd\":5},{\"id\":2,\"nome\":\"Maca\",\"qtd\":3},{\"id\":3,\"nome\":\"Pera\",\"qtd\":1},{\"id\":4,\"nome\":\"Uva\",\"qtd\":6}]"));
    }

}