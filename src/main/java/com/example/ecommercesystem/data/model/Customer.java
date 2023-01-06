package com.example.ecommercesystem.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Set<String> deliveryAddress= new TreeSet<>();
    private List <Order> customerOrders = new ArrayList<>();
}
