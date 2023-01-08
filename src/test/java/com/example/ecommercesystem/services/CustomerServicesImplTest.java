package com.example.ecommercesystem.services;

import com.example.ecommercesystem.dtos.request.CreateCustomerRequest;
import com.example.ecommercesystem.dtos.request.OrderProductRequest;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServicesImplTest {

    @Autowired
    private CustomerServices customerServices;
    private CreateCustomerRequest createCustomerRequest;
    private CreateCustomerRequest createCustomerRequest1;
    private CreateCustomerRequest  createCustomerRequest2;
    private OrderProductRequest orderProductRequest;
    @BeforeEach
    void setUp() {
        createCustomerRequest = new CreateCustomerRequest();
        createCustomerRequest.setEmail("oladejomubarakade@gmail.com");
        createCustomerRequest.setPassword("Adeshina@100");
        createCustomerRequest.setPhoneNumber("0816276807999");
        createCustomerRequest.setAddress("No 2, Sule manager street, Iwo road, Ibadan");

        createCustomerRequest1 = new CreateCustomerRequest();
        createCustomerRequest1.setEmail("oladejo@gmail.com");
        createCustomerRequest1.setPassword("kincaid@10");
        createCustomerRequest1.setPhoneNumber("080456743897673");
        createCustomerRequest1.setAddress("67, Iwaya, Yaba, Lagos");


        createCustomerRequest2 = new CreateCustomerRequest();
        createCustomerRequest2.setEmail("oladejomuba@gmail.com");
        createCustomerRequest2.setPassword("kincaid@101");
        createCustomerRequest2.setPhoneNumber("070456743897673");
        createCustomerRequest2.setAddress("32, Iwaya, Yaba, Lagos");

    }

    @Test
    void testThatCustomerCanRegister() {
        CustomerRegistrationResponse response =
                customerService.register(firstBuyerRegisterRequest);
        CustomerRegistrationResponse response1 =
                customerService.register(secondBuyerRegisterRequest);
        System.out.println(response);
        System.out.println(response1);
        assertEquals(response.getStatusCode(), 201);
        assertEquals("User registration successful", response1.getMessage());
    }

    @Test
    void testThatCustomerCanLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(firstBuyerRegisterRequest.getEmail());
        loginRequest.setPassword(firstBuyerRegisterRequest.getPassword());
        LoginResponse loginResponse = customerService.login(loginRequest);
        System.out.println(loginResponse);
        assertEquals("successful login", loginResponse.getMessage());
    }


    @Test
    void testThatCustomerCanBeUpdated() {
        UpdateRequest updateCustomer = new UpdateRequest();
        updateCustomer.setId(152);
        updateCustomer.setEmail("Emailisupdated@gmail.com");
        updateCustomer.setFirstName("Hakimi");
        updateCustomer.setLastName("Davies");
        updateCustomer.setPhone( "07035893966");
        updateCustomer.setPassword("Englandmoro678#");
        Response updateCustomerResponse =
                customerService.updateCustomer(updateCustomer);
        System.out.println(updateCustomerResponse);
        assertEquals("Customer updated successfully", updateCustomerResponse.getMessage());
    }

    @Test
    void testThatCustomerCanBeDeleted() {
        Response deleteResponse = customerService.deleteCustomer(1);
        System.out.println(deleteResponse);
        assertEquals("Customer deleted", deleteResponse.getMessage());
    }

    @Test
    void testThatCustomerCanOrderProduct() {
        orderProductRequest = new OrderProductRequest();
        orderProductRequest.setCustomerId(1);
        orderProductRequest.setQuantity(4);
        orderProductRequest.setProductName("Versace, Turtle-neck");
        orderProductRequest.setProductCategory(ProductCategory.GROCERIES);
        orderProductRequest.setPrice(17000.00);
        OrderProductResponse orderProductResponse = customerService.orderProduct(orderProductRequest);
        System.out.println(orderProductResponse);
        assertEquals(201, orderProductResponse.getStatusCode());
    }

}