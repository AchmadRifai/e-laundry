package achmad.rifai

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test

@QuarkusTest
class HelloResourceTest {
    @Test
    fun testHello() {
        given()
            .`when`()
            .get("/hello")
            .then()
            .statusCode(200)
            .log()
    }
}