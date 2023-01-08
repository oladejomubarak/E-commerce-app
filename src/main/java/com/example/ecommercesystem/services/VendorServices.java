package com.example.ecommercesystem.services;

import com.example.ecommercesystem.dtos.request.AddProductRequest;
import com.example.ecommercesystem.dtos.request.CreateVendorRequest;
import com.example.ecommercesystem.dtos.request.LoginRequest;
import com.example.ecommercesystem.dtos.request.UpdateVendorRequest;
import com.example.ecommercesystem.dtos.response.AddProductResponse;
import com.example.ecommercesystem.dtos.response.CreateVendorResponse;
import com.example.ecommercesystem.dtos.response.GetResponse;
import com.example.ecommercesystem.dtos.response.LoginResponse;

public interface VendorServices {
    CreateVendorResponse createVendor(CreateVendorRequest createVendorRequest);
    LoginResponse vendorLogin(LoginRequest loginRequest);
    GetResponse updateVendor(UpdateVendorRequest updateRequest);
    GetResponse deleteVendor(String id);

    AddProductResponse addProduct(String id, AddProductRequest addProductRequest);

}
