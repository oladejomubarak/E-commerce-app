package com.example.ecommercesystem.services;

import com.example.ecommercesystem.data.model.ProductCategories;
import com.example.ecommercesystem.data.repository.ProductRepository;
import com.example.ecommercesystem.dtos.request.*;
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

    //private ProductRepository productRepository;

    private CreateVendorRequest createVendorRequest;

    @BeforeEach
    void setUp() {
        createVendorRequest = new CreateVendorRequest();
        createVendorRequest.setFirstName("Ade");
        createVendorRequest.setLastName("Yemi");
        createVendorRequest.setEmail("olademubar@gmail.com");
        createVendorRequest.setPhoneNumber("070234592043456");
        createVendorRequest.setPassword("kincaid@2");
    }

    @Test
    void testThatVendorCanBeCreated() {
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
        updateVendor.setId("63bbe9521609dc350af00e13");
        updateVendor.setEmail("oladejoshina@gmail.com");
        updateVendor.setPhoneNumber("09161931557564");


        GetResponse updateVendorResponse = vendorServices.updateVendor(updateVendor);
        assertEquals("Vendor details updated successfully", updateVendorResponse.getMessage());
    }

    @Test
    void deleteVendor() {
        GetResponse deleteResponse = vendorServices.deleteVendor("63bbe9521609dc350af00e13");
        assertEquals("Vendor deleted successfully", deleteResponse.getMessage());
    }

    @Test
    void testThatVendorCanAddProduct() {
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setName("PS 5 game console");
        addProductRequest.setQuantity(10);
        addProductRequest.setPrice(BigDecimal.valueOf(79000));
        addProductRequest.setProductCategories(ProductCategories.GAME);
        AddProductResponse response = vendorServices.addProduct("63bbfeee675e4f61d43ce375", addProductRequest);
        assertEquals("Product has been added successfully", response.getMessage());
    }


    @Test
    void testThatProductCanBeUpdated() {
        ProductUpdateRequest productUpdateRequest = new ProductUpdateRequest();
        productUpdateRequest.setId("");
        productUpdateRequest.setProductCategories(ProductCategories.BEVERAGES);
        productUpdateRequest.setPrice(BigDecimal.valueOf(24000.00));
        productUpdateRequest.setQuantity(48);
        GetResponse productResponse = vendorServices.updateProduct(productUpdateRequest);
        assertEquals("product has been updated successfully", productResponse.getMessage());

    }

    @Test
    void testThatProductCanBeDeleted() {
        GetResponse deleteResponse = vendorServices.deleteProduct("");
        System.out.println(deleteResponse);
        assertEquals("product successfully deleted", deleteResponse.getMessage());

    }
}