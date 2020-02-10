package com.jfcorugedo.heavydemo.discounts;

import com.jfcorugedo.heavydemo.products.dto.Product;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DiscountCalculatorImpl implements DiscountCalculator {

    private List<Discount> discounts;

    public DiscountCalculatorImpl(List<Discount> discounts) {
        this.discounts = discounts;
    }

    @Override
    public Product applyDiscount(Product product) {
        return product.setPrice(
            discounts
                .stream()
                    .filter(discount -> discount.isApplicable(product))
                    .findFirst()
                    .get()
                        .applyDiscount(product.getPrice())
        );
    }
}
