package com.example.ecommercesystem.controller;

import com.example.ecommercesystem.dtos.request.CreateCustomerRequest;
import com.example.ecommercesystem.dtos.request.LoginRequest;
import com.example.ecommercesystem.dtos.request.OrderProductRequest;
import com.example.ecommercesystem.dtos.request.UpdateCustomerRequest;
import com.example.ecommercesystem.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;

    @PostMapping("/customer")
    public ResponseEntity<?> register(@RequestBody CreateCustomerRequest createCustomerRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerServices.register(createCustomerRequest));
    }
    @GetMapping("/userlogin")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(customerServices.login(loginRequest));
    }
    @PatchMapping("/updatecustomer")
    public ResponseEntity<?> updateCustomer(@RequestBody UpdateCustomerRequest updateCustomerRequest){
        return ResponseEntity.ok(customerServices.updateCustomer(updateCustomerRequest));
    }

    @GetMapping("/allcustomers")
    public ResponseEntity<?> findAllCustomers(){
        return ResponseEntity.ok(customerServices.findAllCustomers());
    }
    @DeleteMapping("/deletecustomer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id){
        return ResponseEntity.ok(customerServices.deleteCustomer(id));
    }
    @PostMapping("/orderproduct")
    public ResponseEntity<?> orderProduct(@RequestBody OrderProductRequest orderProductRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerServices.orderProduct(orderProductRequest));
    }
}
