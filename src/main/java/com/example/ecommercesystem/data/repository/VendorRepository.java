package com.example.ecommercesystem.data.repository;

import com.example.ecommercesystem.data.model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendorRepository extends MongoRepository<Vendor,String> {
}
