package com.example.ecommercesystem.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer extends User {
    @Id
    private String id;
    private Set<String> deliveryAddress= new TreeSet<>();
    @DBRef
    private List <Order> customerOrders = new ArrayList<>();
}
