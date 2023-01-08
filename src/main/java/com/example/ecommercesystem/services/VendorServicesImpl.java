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

    @Autowired
    private ProductServices productServices;

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
        createVendorResponse.setMessage("Vendor created successfully");
        createVendorResponse.setId(savedVendor.getId());
        createVendorResponse.setStatusCode("201");
        return createVendorResponse;
    }

    private void validateInput(CreateVendorRequest  createVendorRequest) {
        if (!UserValidator.isValidEmail(createVendorRequest.getEmail())) throw new RuntimeException(
                String.format("The email %s is invalid", createVendorRequest.getEmail()));
        if (!UserValidator.isValidPassword(createVendorRequest.getPassword())) throw new RuntimeException(
                ("Password is weak, choose a strong one"));
        if (!UserValidator.isValidPhoneNumber(createVendorRequest.getPhoneNumber())) throw new RuntimeException(
                String.format("The phone number %s is invalid", createVendorRequest.getPhoneNumber()));
    }


    @Override
    public LoginResponse vendorLogin(LoginRequest loginRequest) {
        Vendor findVendor = vendorRepository.findVendorByEmail(loginRequest.getEmail()).orElseThrow(()->
                new RuntimeException("Email not found"));
        if(loginRequest.getPassword().equals(findVendor.getPassword()))
            findVendor.setPassword(loginRequest.getPassword());
        else
            throw new RuntimeException("Incorrect password");
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("You're successfully logged in");
        return loginResponse;
    }

    @Override
    public GetResponse updateVendor(UpdateVendorRequest updateVendorRequest) {
        Vendor foundVendor = vendorRepository.findById(updateVendorRequest.getId())
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
        foundVendor.setEmail(updateVendorRequest.getEmail() != null
                && !updateVendorRequest.getEmail().equals("") ? updateVendorRequest.getEmail() : foundVendor.getEmail());
        foundVendor.setPassword(updateVendorRequest.getPassword() != null
                && !updateVendorRequest.getPassword().equals("") ? updateVendorRequest.getPassword() : foundVendor.getPassword());
        foundVendor.setFirstName(updateVendorRequest.getFirstName() != null
                && !updateVendorRequest.getFirstName().equals("") ? updateVendorRequest.getFirstName() : foundVendor.getFirstName());
        foundVendor.setLastName(updateVendorRequest.getLastName() != null
                && !updateVendorRequest.getLastName().equals("") ? updateVendorRequest.getLastName() : foundVendor.getLastName());
        foundVendor.setPhoneNumber(updateVendorRequest.getPhoneNumber() != null
                && !updateVendorRequest.getPhoneNumber().equals("") ? updateVendorRequest.getPhoneNumber() : foundVendor.getPhoneNumber());
        vendorRepository.save(foundVendor);
        return new GetResponse("Vendor details updated successfully");
    }

    @Override
    public GetResponse deleteVendor(String id) {
        Vendor foundVendor = vendorRepository.findById(id).orElseThrow(()-> new
                RuntimeException("Vendor with the id"+ id +"not found"));
        vendorRepository.delete(foundVendor);
        return new GetResponse("Vendor deleted successfully");
    }

    @Override
    public AddProductResponse addProduct(String id, AddProductRequest addProductRequest) {

        return null;
    }
}
