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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServicesImpl implements CustomerServices{
    @Override
    public CreateCustomerResponse register(CreateCustomerRequest createCustomerRequest) {
        return null;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public GetResponse updateCustomer(UpdateCustomerRequest updateCustomerRequest) {
        return null;
    }

    @Override
    public OrderProductResponse orderProduct(OrderProductRequest orderProductRequest) {
        return null;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return null;
    }

    @Override
    public GetResponse deleteCustomer(int id) {
        return null;
    }
}
