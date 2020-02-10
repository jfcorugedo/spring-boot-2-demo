package com.jfcorugedo.heavydemo.discounts;

import com.jfcorugedo.heavydemo.products.dto.Product;

public interface DiscountCalculator {

    Product applyDiscount(Product product);
}
