package com.example.ecommercesystem.data.repository;

import com.example.ecommercesystem.data.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
