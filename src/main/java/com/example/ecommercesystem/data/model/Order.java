package com.example.ecommercesystem.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class Order {
    @Id
    private String id;
    private String productName;
    private ProductCategories productCategories;
    private BigDecimal price;
    private String quantity;
    private double total;

}
