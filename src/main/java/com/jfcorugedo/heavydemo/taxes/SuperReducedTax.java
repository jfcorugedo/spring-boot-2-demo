package com.jfcorugedo.heavydemo.taxes;

import com.jfcorugedo.heavydemo.products.dto.Product;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class SuperReducedTax implements Tax {

    private static final BigDecimal SUPER_REDUCED_TAX = new BigDecimal("1.04");

    @Override
    public BigDecimal applyTax(BigDecimal price) {
        System.out.println("Applying SUPER-REDUCED tax");
        return SUPER_REDUCED_TAX.multiply(price);
    }

    @Override
    public boolean isApplicable(Product product) {
        return product.getName().equals("Macbook");
    }
}
