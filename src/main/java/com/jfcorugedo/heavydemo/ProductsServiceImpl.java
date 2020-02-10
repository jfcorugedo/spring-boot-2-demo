package com.jfcorugedo.heavydemo;

import com.jfcorugedo.heavydemo.products.ProductsRepository;
import com.jfcorugedo.heavydemo.products.ProductsService;
import com.jfcorugedo.heavydemo.products.dto.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl implements ProductsService {

    private ProductsRepository productsRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<Product> getAll() {
        return productsRepository.findAll();
    }

    @Override
    public Optional<Product> findOne(String id) {
        return this.productsRepository.findById(id);
    }
}
