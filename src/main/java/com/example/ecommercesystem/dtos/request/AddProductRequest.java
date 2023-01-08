package com.example.ecommercesystem.dtos.request;

import com.example.ecommercesystem.data.model.ProductCategories;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddProductRequest {
    private String id;
    private String name;
    private BigDecimal price;
    private ProductCategories productCategories;
    public int quantity;
}
