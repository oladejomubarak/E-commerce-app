package com.example.ecommercesystem.services;

import com.example.ecommercesystem.data.model.ProductCategories;
import com.example.ecommercesystem.dtos.request.CreateCustomerRequest;
import com.example.ecommercesystem.dtos.request.LoginRequest;
import com.example.ecommercesystem.dtos.request.OrderProductRequest;
import com.example.ecommercesystem.dtos.request.UpdateCustomerRequest;
import com.example.ecommercesystem.dtos.response.CreateCustomerResponse;
import com.example.ecommercesystem.dtos.response.GetResponse;
import com.example.ecommercesystem.dtos.response.LoginResponse;
import com.example.ecommercesystem.dtos.response.OrderProductResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
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

    @Test void testThatCustomerCanRegister() {
        CreateCustomerResponse resp =
                customerServices.register(createCustomerRequest);
//        CreateCustomerResponse resp1 =
//                customerServices.register(createCustomerRequest1);
        assertEquals("201", resp.getStatusCode());
        //assertEquals("Customer created successfully", resp1.getMessage());
    }

    @Test
    void testThatCustomerCanLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(createCustomerRequest1.getEmail());
        loginRequest.setPassword(createCustomerRequest1.getPassword());
        LoginResponse loginResponse = customerServices.login(loginRequest);
        assertEquals("You're successfully logged in", loginResponse.getMessage());
    }


    @Test
    void testThatCustomerDetailsCanBeUpdated() {
        UpdateCustomerRequest customerUpdate = new UpdateCustomerRequest();
        customerUpdate.setId("63bb4c522411284866b235a1");
        customerUpdate.setEmail("updatedmai@gmail.com");
        customerUpdate.setFirstName("Chibuzor");
        GetResponse updateResponse =
                customerServices.updateCustomer(customerUpdate);
        assertEquals("Your details are updated successfully", updateResponse.getMessage());
    }

    @Test
    void testThatCustomerCanBeDeleted() {
        GetResponse delResponse = customerServices.deleteCustomer("");
        assertEquals("Customer has been deleted", delResponse.getMessage());
    }

    @Test void testThatCustomerCanOrderProduct() {
        orderProductRequest = new OrderProductRequest();
        orderProductRequest.setCustomerId("63bb4c522411284866b235a1");
        orderProductRequest.setQuantity(2);
        orderProductRequest.setProductName("sneakers");
        orderProductRequest.setProductCategories(ProductCategories.FASHION);
        orderProductRequest.setPrice(23000.00);
        OrderProductResponse orderResponse = customerServices.orderProduct(orderProductRequest);
        assertEquals("Order placed successfully", orderResponse.getMessage());
    }

}