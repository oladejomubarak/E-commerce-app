package com.example.ecommercesystem.services;

public interface VendorServices {
    CreateVendorResponse createVendor(CreateVendorRequest createVendorRequest);
    LoginResponse login(LoginRequest loginRequest);
    Response updateVendor(UpdateRequest updateRequest);
    Response deleteVendor(int id);

    Response addProduct(int id, AddProductRequest addProductRequest);

}
