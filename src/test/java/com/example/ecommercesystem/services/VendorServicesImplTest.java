package com.example.ecommercesystem.services;

import com.example.ecommercesystem.data.model.ProductCategories;
import com.example.ecommercesystem.dtos.request.AddProductRequest;
import com.example.ecommercesystem.dtos.request.CreateVendorRequest;
import com.example.ecommercesystem.dtos.request.LoginRequest;
import com.example.ecommercesystem.dtos.request.UpdateVendorRequest;
import com.example.ecommercesystem.dtos.response.AddProductResponse;
import com.example.ecommercesystem.dtos.response.CreateVendorResponse;
import com.example.ecommercesystem.dtos.response.GetResponse;
import com.example.ecommercesystem.dtos.response.LoginResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VendorServicesImplTest {

    @Autowired
    private VendorServices vendorServices;

    private CreateVendorRequest createVendorRequest;

    @BeforeEach
    void setUp() {
        createVendorRequest = new CreateVendorRequest();
        createVendorRequest.setFirstName("Ade");
        createVendorRequest.setLastName("Yemi");
        createVendorRequest.setPhoneNumber("070234592043456");
        createVendorRequest.setPassword("kincaid@2");
    }

    @Test void testThatVendorCanBeCreated() {
        CreateVendorResponse vendorResponse =
                vendorServices.createVendor(createVendorRequest);
        assertEquals("Vendor created successfully", vendorResponse.getMessage());
    }

    @Test
    void login() {
        LoginRequest loginVendor = new LoginRequest();
        loginVendor.setEmail(createVendorRequest.getEmail());
        loginVendor.setPassword(createVendorRequest.getPassword());
        LoginResponse response = vendorServices.vendorLogin(loginVendor);
        assertEquals("You're successfully logged in", response.getMessage());
    }

    @Test
    void updateVendor() {
        UpdateVendorRequest updateVendor = new UpdateVendorRequest();
        updateVendor.setId("");
        updateVendor.setEmail("oladejoshina@gmail.com");
        updateVendor.setPhoneNumber("09161931557564");


        GetResponse updateVendorResponse = vendorServices.updateVendor(updateVendor);
        assertEquals("Vendor details updated successfully", updateVendorResponse.getMessage());
    }

    @Test
    void deleteVendor() {
        GetResponse deleteResponse = vendorServices.deleteVendor("");
        assertEquals("Vendor deleted successfully", deleteResponse.getMessage());
    }

    @Test
    void testThatVendorCanAddProduct() {
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setName("PS 5 game console");
        addProductRequest.setQuantity(10);
        addProductRequest.setPrice(BigDecimal.valueOf(79000));
        addProductRequest.setProductCategories(ProductCategories.GAME);
        AddProductResponse response = vendorServices.addProduct("", addProductRequest);
        assertEquals("Product has been added successfully", response.getMessage());
    }









    @Test
    void testThatProductCanBeUpdated() {
        ProductUpdateRequest productUpdateRequest = new ProductUpdateRequest();
        productUpdateRequest.setId(352);
        productUpdateRequest.setCategory(String.valueOf(ProductCategory.APPLIANCES));
        productUpdateRequest.setName("Standing Fan");
        productUpdateRequest.setPrice(BigDecimal.valueOf(24000.00));
        productUpdateRequest.setQuantity(20);
        Response response = productService.updateProduct(productUpdateRequest);
        System.out.println(response);
        assertEquals("Product update successful", response.getMessage());

    }

    @Test
    void testThatProductCanBeDeleted() {
        Response deleteResponse = productService.deleteProduct(52);
        System.out.println(deleteResponse);
        assertEquals("Product has been deleted", deleteResponse.getMessage());

}