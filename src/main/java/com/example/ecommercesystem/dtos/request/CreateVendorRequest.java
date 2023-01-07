package com.example.ecommercesystem.dtos.request;

import lombok.Data;

@Data
public class CreateVendorRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
}
