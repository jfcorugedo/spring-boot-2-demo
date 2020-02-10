package com.jfcorugedo.heavydemo.products;

import com.jfcorugedo.heavydemo.products.dto.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepository extends MongoRepository<Product, String> {

}
