package com.jfcorugedo.heavydemo.products;

import com.jfcorugedo.heavydemo.discounts.DiscountCalculator;
import com.jfcorugedo.heavydemo.products.dto.Product;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl implements ProductsService {

    private ProductsRepository productsRepository;
    private DiscountCalculator discountCalculator;

    public ProductsServiceImpl(ProductsRepository productsRepository, DiscountCalculator discountCalculator) {
        this.productsRepository = productsRepository;
        this.discountCalculator = discountCalculator;
    }

    @Override
    public List<Product> getAll() {

        return productsRepository
            .findAll().stream()
            .map(discountCalculator::applyDiscount)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findOne(String id) {
        return this.productsRepository.findById(id).map(discountCalculator::applyDiscount);
    }
}
