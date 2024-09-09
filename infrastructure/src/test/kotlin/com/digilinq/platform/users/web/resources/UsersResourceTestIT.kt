package com.digilinq.platform.users.web.resources

import com.digilinq.platform.users.Application
import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import org.hamcrest.Matchers
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@Tag("IntegrationTests")
@ExtendWith(SpringExtension::class)
@AutoConfigureDataMongo
@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class UsersResourceTestIT {

    @Value("\${test.host}")
    private lateinit var host: String

    @LocalServerPort
    private val port: Int = 0

    private lateinit var requestSpecification: RequestSpecification

    @BeforeEach
    fun setUp() {
        requestSpecification = RestAssured.given()
            .baseUri(host)
            .port(port)
            .headers(
                mapOf(
                    "api-key" to "test-key",
                )
            )
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
    }

    @Test
    fun `should work`() {
        requestSpecification.`when`()
            .get("/swagger-ui.html")
            .then()
            .statusCode(200)
    }
}