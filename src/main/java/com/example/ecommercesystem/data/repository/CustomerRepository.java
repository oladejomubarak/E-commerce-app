package com.example.ecommercesystem.data.repository;

import com.example.ecommercesystem.data.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
