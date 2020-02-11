package com.jfcorugedo.heavydemo.taxes;

import com.jfcorugedo.heavydemo.products.dto.Product;
import java.math.BigDecimal;

public interface Tax {

    BigDecimal applyTax(BigDecimal price);

    boolean isApplicable(Product product);
}
