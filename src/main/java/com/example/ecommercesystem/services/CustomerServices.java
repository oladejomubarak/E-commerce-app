package com.example.ecommercesystem.services;

import com.example.ecommercesystem.data.model.Customer;
import com.example.ecommercesystem.dtos.request.CreateCustomerRequest;
import com.example.ecommercesystem.dtos.request.LoginRequest;
import com.example.ecommercesystem.dtos.request.OrderProductRequest;
import com.example.ecommercesystem.dtos.request.UpdateCustomerRequest;
import com.example.ecommercesystem.dtos.response.CreateCustomerResponse;
import com.example.ecommercesystem.dtos.response.GetResponse;
import com.example.ecommercesystem.dtos.response.LoginResponse;
import com.example.ecommercesystem.dtos.response.OrderProductResponse;

import java.util.List;

public interface CustomerServices {
    CreateCustomerResponse register(CreateCustomerRequest createCustomerRequest);
    LoginResponse login(LoginRequest loginRequest);
    GetResponse updateCustomer(UpdateCustomerRequest updateCustomerRequest);


    OrderProductResponse orderProduct
            (OrderProductRequest orderProductRequest);

    List<Customer> findAllCustomers();

    GetResponse deleteCustomer(int id);
}
