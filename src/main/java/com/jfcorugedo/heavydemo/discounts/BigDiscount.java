package com.jfcorugedo.heavydemo.discounts;

import com.jfcorugedo.heavydemo.products.dto.Product;
import java.math.BigDecimal;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(10)
@Component
public class BigDiscount implements Discount {

    public static final BigDecimal BIG_DISCOUNT = new BigDecimal("0.5");

    @Override
    public BigDecimal applyDiscount(BigDecimal price) {
        return price.multiply(BIG_DISCOUNT);
    }

    @Override
    public boolean isApplicable(Product product) {
        return product.getName().equals("iPhone");
    }
}
