package com.jfcorugedo.heavydemo.taxes;

import com.jfcorugedo.heavydemo.products.dto.Product;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TaxCalculator {

    private List<Tax> taxes;

    public TaxCalculator(List<Tax> taxes) {
        this.taxes = taxes;
    }

    public Product applyTaxes(Product product) {
        return product.setPrice(
            taxes.stream()
                .filter(tax -> tax.isApplicable(product))
                .findFirst()
                .get()
                .applyTax(product.getPrice())
        );
    }
}
