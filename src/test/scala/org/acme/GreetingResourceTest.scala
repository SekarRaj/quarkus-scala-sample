package org.acme

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingResourceTest {

  @Test
  def testGreetingEndpoint(): Unit = {
    given()
      .`when`().get("/hello/greeting/sappa")
      .`then`()
      .statusCode(200)
      .body(`is`("Hello, sappa"))
  }
}