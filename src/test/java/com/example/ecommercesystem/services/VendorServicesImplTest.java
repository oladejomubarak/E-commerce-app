package com.example.ecommercesystem.services;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class VendorServicesImplTest {

    @Autowired
    private VendorService vendorService;

    private CreateVendorRequest createVendorRequest;

    @BeforeEach
    void setUp() {
        createVendorRequest = new CreateVendorRequest();
        createVendorRequest.setStoreName("Ikeja City Mall");
        createVendorRequest.setPhoneNumber("08123459204");
        createVendorRequest.setEmailAddress("helloworld@gmail.com");
        createVendorRequest.setPassword("Iamnotalone#12");
        createVendorRequest.setStoreAddress("No 45, Abiola way, Lagos");
    }

    @Test
    void createVendor() {
        CreateVendorResponse vendorResponse =
                vendorService.createVendor(createVendorRequest);
        System.out.println(vendorResponse);
        assertEquals("Successfully registered", vendorResponse.getMessage());
    }

    @Test
    void login() {
        LoginRequest login = new LoginRequest();
        login.setEmail(createVendorRequest.getEmailAddress());
        login.setPassword(createVendorRequest.getPassword());
        LoginResponse response = vendorService.login(login);
        System.out.println(response);
        assertEquals("login is successful", response.getMessage());
    }

    @Test
    void updateVendor() {
        UpdateRequest requestUpdate = new UpdateRequest();
        requestUpdate.setId(2);
        requestUpdate.setPhone("09161931557");
        requestUpdate.setPassword("Youwillnever!17");
        requestUpdate.setEmail("daredevil@yahoo.com");

        Response updateResponse = vendorService.updateVendor(requestUpdate);
        System.out.println(updateResponse);
        assertEquals("Vendor has been updated", updateResponse.getMessage());
    }

    @Test
    void deleteVendor() {
        Response delResponse = vendorService.deleteVendor(102);
        System.out.println(delResponse);
        assertEquals("Deleted", delResponse.getMessage());
    }

    @Test
    void testThatVendorCanAddProduct() {
        AddProductRequest productRequest = new AddProductRequest();
        productRequest.setName("LG 55inch LED Television");
        productRequest.setPrice(BigDecimal.valueOf(149000));
        productRequest.setProductQuantity(5);
        productRequest.setCategory(ProductCategory.COMPUTING);
        Response response = vendorService.addProduct(1, productRequest);
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