package com.jfcorugedo.heavydemo.taxes;

import com.jfcorugedo.heavydemo.products.dto.Product;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class ReducedTax implements Tax {

    private static final BigDecimal REDUCED_TAX = new BigDecimal("1.10");

    @Override
    public BigDecimal applyTax(BigDecimal price) {
        System.out.println("Applying REDUCED tax");
        return REDUCED_TAX.multiply(price);
    }

    @Override
    public boolean isApplicable(Product product) {
        return product.getName().equals("iPhone");
    }
}
