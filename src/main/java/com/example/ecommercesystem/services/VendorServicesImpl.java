package com.example.ecommercesystem.services;

import com.example.ecommercesystem.data.model.Customer;
import com.example.ecommercesystem.data.model.Vendor;
import com.example.ecommercesystem.data.repository.ProductRepository;
import com.example.ecommercesystem.data.repository.VendorRepository;
import com.example.ecommercesystem.dtos.request.*;
import com.example.ecommercesystem.dtos.response.*;
import com.example.ecommercesystem.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServicesImpl implements VendorServices{
    @Autowired
    private VendorRepository vendorRepository;

    //@Autowired
    //private ProductServices productServices;

    private final Vendor vendor = new Vendor();
    @Override
    public CreateVendorResponse createVendor(CreateVendorRequest createVendorRequest) {
        validateInput(createVendorRequest);
        return registerCustomer(createVendorRequest);
    }
    private CreateVendorResponse registerCustomer(CreateVendorRequest createVendorRequest) {
        if(vendorRepository.findVendorByEmail(createVendorRequest.getEmail()).isPresent())
            throw new RuntimeException("The email already exists, try another email");
        else
            vendor.setEmail(createVendorRequest.getEmail());
        if(vendorRepository.findVendorByPhoneNumber(createVendorRequest.getPhoneNumber()).isPresent())
            throw new RuntimeException("Phone number already exists, choose another phone number");
        else
            vendor.setPhoneNumber(createVendorRequest.getPhoneNumber());
        vendor.setFirstName(createVendorRequest.getFirstName());
        vendor.setLastName(createVendorRequest.getLastName());
        vendor.setPassword(createVendorRequest.getPassword());


        Vendor savedVendor = vendorRepository.save(vendor);

        CreateVendorResponse createVendorResponse = new CreateVendorResponse();
        createVendorResponse.setMessage("User created successfully");
        createVendorResponse.setId(savedVendor.getId());
        createVendorResponse.setStatusCode("201");
        return createVendorResponse;
    }

    private void validateInput(CreateVendorRequest  createVendorRequest) {
        if (!UserValidator.isValidEmail(createVendorRequest.getEmail())) throw new RuntimeException(
                String.format("The email %s is invalid", createVendorRequest.getEmail()));
        if (!UserValidator.isValidPassword(createVendorRequest.getPassword())) throw new RuntimeException(
                String.format("Password %s is weak, choose a strong one", createVendorRequest.getPassword()));
        if (!UserValidator.isValidPhoneNumber(createVendorRequest.getPhoneNumber())) throw new RuntimeException(
                String.format("The phone number %s is invalid", createVendorRequest.getPhoneNumber()));
    }


    @Override
    public LoginResponse vendorLogin(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public GetResponse updateVendor(UpdateVendorRequest updateRequest) {
        return null;
    }

    @Override
    public GetResponse deleteVendor(int id) {
        return null;
    }

    @Override
    public AddProductResponse addProduct(int id, AddProductRequest addProductRequest) {
        return null;
    }
}
