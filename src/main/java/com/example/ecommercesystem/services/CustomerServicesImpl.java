package com.example.ecommercesystem.services;

import com.example.ecommercesystem.data.model.Customer;
import com.example.ecommercesystem.data.repository.CustomerRepository;
import com.example.ecommercesystem.data.repository.OrderRepository;
import com.example.ecommercesystem.dtos.request.CreateCustomerRequest;
import com.example.ecommercesystem.dtos.request.LoginRequest;
import com.example.ecommercesystem.dtos.request.OrderProductRequest;
import com.example.ecommercesystem.dtos.request.UpdateCustomerRequest;
import com.example.ecommercesystem.dtos.response.CreateCustomerResponse;
import com.example.ecommercesystem.dtos.response.GetResponse;
import com.example.ecommercesystem.dtos.response.LoginResponse;
import com.example.ecommercesystem.dtos.response.OrderProductResponse;
import com.example.ecommercesystem.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServicesImpl implements CustomerServices{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    private final Customer customer = new Customer();
    @Override
    public CreateCustomerResponse register(CreateCustomerRequest createCustomerRequest) {
        validateInput(createCustomerRequest);
        return registerCustomer(createCustomerRequest);
    }

    private CreateCustomerResponse registerCustomer(CreateCustomerRequest createUserRequest) {
        if(customerRepository.findCustomerByEmail(createUserRequest.getEmail()).isPresent())
            throw new RuntimeException("The email already exists, try another email");
        else
            customer.setEmail(createUserRequest.getEmail());
        if(customerRepository.findCustomerByEmail(createUserRequest.getPhoneNumber()).isPresent())
            throw new RuntimeException("Phone number already exists, choose another phone number");
        else
            customer.setPhoneNumber(createUserRequest.getPhoneNumber());
        customer.setFirstName(createUserRequest.getFirstName());
        customer.setLastName(createUserRequest.getLastName());
        customer.setPassword(createUserRequest.getPassword());


        Customer savedCustomer = customerRepository.save(customer);

        CreateCustomerResponse createUserResponse = new CreateCustomerResponse();
        createUserResponse.setMessage("User created successfully");
        createUserResponse.setId(savedCustomer.getId());
        createUserResponse.setStatusCode("201");
        return createUserResponse;
    }

    private void validateInput(CreateCustomerRequest createCustomerRequest) {
        if (!UserValidator.isValidEmail(createCustomerRequest.getEmail())) throw new RuntimeException(
                String.format("The email %s is invalid", createCustomerRequest.getEmail()));
        if (!UserValidator.isValidPassword(createCustomerRequest.getPassword())) throw new RuntimeException(
                String.format("Password %s is weak, choose a strong one", createCustomerRequest.getPassword()));
        if (!UserValidator.isValidPhoneNumber(createCustomerRequest.getPhoneNumber())) throw new RuntimeException(
                String.format("The phone number %s is invalid", createCustomerRequest.getPhoneNumber()));
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        Customer foundCustomer = customerRepository.findCustomerByEmail(loginRequest.getEmail()).orElseThrow(()->
                new RuntimeException("Email not found"));
        //findUser.setEmail(loginRequest.getEmail());
        if(loginRequest.getPassword().equals(foundCustomer.getPassword()))
            foundCustomer.setPassword(loginRequest.getPassword());
        else
            throw new RuntimeException("Incorrect password");
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("You're successfully logged in");
        return loginResponse;
    }

    @Override
    public GetResponse updateCustomer(UpdateCustomerRequest updateCustomerRequest) {
        Customer foundCustomer = customerRepository.findById(updateCustomerRequest.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        foundCustomer.setEmail(updateCustomerRequest.getEmail() != null
                && !updateCustomerRequest.getEmail().equals("") ? updateCustomerRequest.getEmail() : foundCustomer.getEmail());
        foundCustomer.setPassword(updateCustomerRequest.getPassword() != null
                && !updateCustomerRequest.getPassword().equals("") ? updateCustomerRequest.getPassword() : foundCustomer.getPassword());
        foundCustomer.setFirstName(updateCustomerRequest.getFirstName() != null
                && !updateCustomerRequest.getFirstName().equals("") ? updateCustomerRequest.getFirstName() : foundCustomer.getFirstName());foundCustomer.setLastName(updateCustomerRequest.getLastName() != null
                && !updateCustomerRequest.getLastName().equals("") ? updateCustomerRequest.getLastName() : foundCustomer.getLastName());
        foundCustomer.setPhoneNumber(updateCustomerRequest.getPhoneNumber() != null
                && !updateCustomerRequest.getPhoneNumber().equals("") ? updateCustomerRequest.getPhoneNumber() : foundCustomer.getPhoneNumber());
        customerRepository.save(foundCustomer);
        return new GetResponse("User detail updated successfully");
    }

    @Override
    public OrderProductResponse orderProduct(OrderProductRequest orderProductRequest) {
        return null;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return null;
    }

    @Override
    public GetResponse deleteCustomer(int id) {
        return null;
    }
}
