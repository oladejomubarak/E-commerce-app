package com.example.ecommercesystem.dtos.request;

import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private String id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
