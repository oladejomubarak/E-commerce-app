package com.example.ecommercesystem.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Vendor {
    @Id
    private String id;
    private String storeNumber;
    private Set<String> storeAddress = new HashSet<>();
    private List<Product> products = new ArrayList<>();
}
