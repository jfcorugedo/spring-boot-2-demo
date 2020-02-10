package com.jfcorugedo.heavydemo.it;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import com.jfcorugedo.heavydemo.products.dto.Product;
import com.jfcorugedo.heavydemo.users.dto.Role;
import com.jfcorugedo.heavydemo.users.dto.User;
import io.restassured.http.ContentType;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductsControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void setUp() {
        mongoTemplate.dropCollection("product");
        saveProduct("iPhone", "The best mobile in the world", new BigDecimal(800));
        saveProduct("Macbook", "The best laptop in the world", new BigDecimal(1999.99));
        saveProduct("iWatch", "The best watch in the world", new BigDecimal(329.99));
    }

    private void saveProduct(String name, String description, BigDecimal price) {
        mongoTemplate.save(
            new Product()
                .setName(name)
                .setDescription(description)
                .setPrice(price),
            "product"
        );
    }

    @Test
    public void getAllUsersReturnsAllOfThem() {

        given()
            .get(String.format("http://localhost:%d/products", port))
        .then()
            .statusCode(HttpStatus.OK.value())
            .contentType(ContentType.JSON)
            .body("size()", is(3));
    }
}
