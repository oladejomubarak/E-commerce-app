package com.example.ecommercesystem.services;

import com.example.ecommercesystem.data.model.Product;
import com.example.ecommercesystem.dtos.request.*;
import com.example.ecommercesystem.dtos.response.AddProductResponse;
import com.example.ecommercesystem.dtos.response.CreateVendorResponse;
import com.example.ecommercesystem.dtos.response.GetResponse;
import com.example.ecommercesystem.dtos.response.LoginResponse;

public interface VendorServices {
    CreateVendorResponse createVendor(CreateVendorRequest createVendorRequest);
    LoginResponse vendorLogin(LoginRequest loginRequest);
    GetResponse updateVendor(UpdateVendorRequest updateRequest);
    GetResponse deleteVendor(String id);

    AddProductResponse addProduct(String vendorId, AddProductRequest addProductRequest);

    Product findProductById(String id);
    GetResponse updateProduct (ProductUpdateRequest productUpdateRequest);

    GetResponse deleteProduct(String productId);

}
