package com.example.ecommercesystem.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {
    private String storeNumber;
    private Set<String> storeAddress = new HashSet<>();
}
