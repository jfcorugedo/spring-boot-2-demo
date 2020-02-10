package com.jfcorugedo.heavydemo.discounts;

import com.jfcorugedo.heavydemo.products.dto.Product;
import java.math.BigDecimal;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(20)
@Component
public class BasicDiscount implements Discount {

    private static final BigDecimal BASIC_DISCOUNT = new BigDecimal("0.1");

    @Override
    public BigDecimal applyDiscount(BigDecimal price) {
        return price.multiply(BASIC_DISCOUNT);
    }

    @Override
    public boolean isApplicable(Product product) {
        return product.getName().equals("iWatch");
    }
}
