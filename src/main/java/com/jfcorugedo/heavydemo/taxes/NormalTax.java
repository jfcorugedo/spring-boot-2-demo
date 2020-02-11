package com.jfcorugedo.heavydemo.taxes;

import com.jfcorugedo.heavydemo.products.dto.Product;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class NormalTax implements Tax {

    private static final BigDecimal NORMAL_TAX = new BigDecimal("1.21");

    @Override
    public BigDecimal applyTax(BigDecimal price) {
        System.out.println("Applying NORMAL tax");
        return NORMAL_TAX.multiply(price);
    }

    @Override
    public boolean isApplicable(Product product) {
        return true;
    }
}
