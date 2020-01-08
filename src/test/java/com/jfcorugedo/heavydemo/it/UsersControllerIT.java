package com.jfcorugedo.heavydemo.it;

import com.jfcorugedo.heavydemo.users.dto.Role;
import com.jfcorugedo.heavydemo.users.dto.User;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsersControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void setUp() {
        mongoTemplate.dropCollection("user");
        mongoTemplate.save(new User().setId("1").setName("Juan").setSurname("Corugedo").setRole(Role.ADMIN), "user");
        mongoTemplate.save(new User().setId("2").setName("Miguel").setSurname("Garvia").setRole(Role.CUSTOMER), "user");
        mongoTemplate.save(new User().setId("3").setName("Luigi").setSurname("Navarro").setRole(Role.MANAGER), "user");
    }

    @Test
    public void getAllUsersReturnsAllOfThem() {

        given()
            .get(String.format("http://localhost:%d/users", port))
        .then()
            .statusCode(HttpStatus.OK.value())
            .contentType(ContentType.JSON)
            .body("size()", is(3));
    }


}
