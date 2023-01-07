package com.example.ecommercesystem.dtos.request;

import com.example.ecommercesystem.data.model.ProductCategories;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderProductRequest {
    private String customerId;
    private String productName;
    private ProductCategories productCategories;
    private double price;
    private int quantity;
}
