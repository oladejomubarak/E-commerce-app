package com.example.ecommercesystem.data.model;

import jakarta.xml.bind.annotation.XmlEnum;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
@Data
@Document
public class Product {
    private String id;
    private String name;
    private ProductCategories productCategories;
    private String vendorId;
    private BigDecimal price;
    private String quantity;
}
