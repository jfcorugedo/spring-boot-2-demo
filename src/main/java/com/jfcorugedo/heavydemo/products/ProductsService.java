package com.jfcorugedo.heavydemo.products;

import com.jfcorugedo.heavydemo.products.dto.Product;
import java.util.List;
import java.util.Optional;

public interface ProductsService {

    List<Product> getAll();

    Optional<Product> findOne(String id);
}
