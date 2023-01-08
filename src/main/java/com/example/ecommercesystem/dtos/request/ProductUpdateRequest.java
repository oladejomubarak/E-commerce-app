package com.example.ecommercesystem.dtos.request;

import com.example.ecommercesystem.data.model.ProductCategories;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateRequest {
    public String id;
    public String name;
    public BigDecimal price;
    public ProductCategories productCategories;
    public int quantity;
}
