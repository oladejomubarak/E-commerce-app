package com.example.ecommercesystem.data.repository;

import com.example.ecommercesystem.data.model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VendorRepository extends MongoRepository<Vendor,String> {
    Optional<Vendor> findVendorByEmail(String email);
}
