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
        saveProduct("1", "iPhone", "The best mobile in the world", new BigDecimal("800"));
        saveProduct("2","Macbook", "The best laptop in the world", new BigDecimal("1999.99"));
        saveProduct("3","iWatch", "The best watch in the world", new BigDecimal("329.99"));
    }

    private void saveProduct(String id, String name, String description, BigDecimal price) {
        mongoTemplate.save(
            new Product()
                .setId(id)
                .setName(name)
                .setDescription(description)
                .setPrice(price),
            "product"
        );
    }

    @Test
    public void getAllProducts() {

        given()
            .get(String.format("http://localhost:%d/products", port))
        .then()
            .statusCode(HttpStatus.OK.value())
            .contentType(ContentType.JSON)
            .body("size()", is(3));
    }

    @Test
    public void getOneProduct() {

        given()
            .get(String.format("http://localhost:%d/products/3", port))
            .then()
            .statusCode(HttpStatus.OK.value())
            .contentType(ContentType.JSON)
            .body("id", is("3"))
            .and()
            .body("name", is("iWatch"))
            .and()
            .body("description", is("The best watch in the world"))
            .and()
            .body("price", is( 39.92879f));
    }

    @Test
    public void ensureProperDiscountIsApplied() {

        given()
            .get(String.format("http://localhost:%d/products", port))
            .then()
            .statusCode(HttpStatus.OK.value())
            .contentType(ContentType.JSON)
            .body("size()", is(3))
            .and()
            .body("[0].price", is(440.0f))
            .and()
            .body("[1].price", is( 2079.9895f))
            .and()
            .body("[2].price", is( 39.92879f));
    }
}
