package com.jfcorugedo.heavydemo.discounts;

import com.jfcorugedo.heavydemo.products.dto.Product;
import java.math.BigDecimal;

public interface Discount {

    BigDecimal applyDiscount(BigDecimal price);

    boolean isApplicable(Product product);
}
