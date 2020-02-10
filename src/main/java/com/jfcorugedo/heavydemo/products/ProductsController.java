package com.jfcorugedo.heavydemo.products;

import com.jfcorugedo.heavydemo.products.dto.Product;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductsController {

    ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public List<Product> getAll() {
        return this.productsService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getOne(@PathVariable String id) {

        return
            this.productsService
                .findOne(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElse(ResponseEntity.notFound().build());
    }
}
