package com.example.ecommercesystem.data.repository;

import com.example.ecommercesystem.data.model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface VendorRepository extends MongoRepository<Vendor,String> {
    Optional<Vendor> findVendorByEmail(String email);
    Optional<Vendor> findVendorByPhoneNumber(String phoneNumber);
}
