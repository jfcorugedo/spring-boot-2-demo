package com.jfcorugedo.heavydemo.discounts;

import com.jfcorugedo.heavydemo.products.dto.Product;
import java.math.BigDecimal;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(Ordered.LOWEST_PRECEDENCE)
@Component
public class NoDiscount implements Discount {

    /**
     * No discount will be applied
     */
    @Override
    public BigDecimal applyDiscount(BigDecimal price) {
        return price;
    }

    @Override
    public boolean isApplicable(Product product) {
        return true;
    }
}
