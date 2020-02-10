package com.jfcorugedo.heavydemo.products.dto;

import java.math.BigDecimal;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors( chain = true )
public class Product {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
