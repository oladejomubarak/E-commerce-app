package com.example.ecommercesystem.controller;

import com.example.ecommercesystem.dtos.request.CreateCustomerRequest;
import com.example.ecommercesystem.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;

    @PostMapping("/customer")
    public ResponseEntity<?> register(@RequestBody CreateCustomerRequest createCustomerRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerServices.register(createCustomerRequest));
    }


}
