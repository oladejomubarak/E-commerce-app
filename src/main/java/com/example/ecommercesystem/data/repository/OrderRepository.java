package com.example.ecommercesystem.data.repository;

import com.example.ecommercesystem.data.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

}
