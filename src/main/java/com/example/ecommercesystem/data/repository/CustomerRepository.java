package com.example.ecommercesystem.data.repository;

import com.example.ecommercesystem.data.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findCustomerByEmail(String email);
    Optional<Customer> findCustomerByPhoneNumber(String phoneNumber);

}
