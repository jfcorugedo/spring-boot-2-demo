package com.jfcorugedo.heavydemo.products;

import com.jfcorugedo.heavydemo.discounts.DiscountCalculator;
import com.jfcorugedo.heavydemo.products.dto.Product;
import com.jfcorugedo.heavydemo.taxes.TaxCalculator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl implements ProductsService {

    private ProductsRepository productsRepository;
    private DiscountCalculator discountCalculator;
    private TaxCalculator taxCalculator;

    public ProductsServiceImpl(ProductsRepository productsRepository, DiscountCalculator discountCalculator, TaxCalculator taxCalculator) {
        this.productsRepository = productsRepository;
        this.discountCalculator = discountCalculator;
        this.taxCalculator = taxCalculator;
    }

    @Override
    public List<Product> getAll() {

        return productsRepository
            .findAll().stream()
            .map(discountCalculator::applyDiscount)
            .map(taxCalculator::applyTaxes)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findOne(String id) {
        return this.productsRepository
            .findById(id)
            .map(discountCalculator::applyDiscount)
            .map(taxCalculator::applyTaxes);
    }
}
