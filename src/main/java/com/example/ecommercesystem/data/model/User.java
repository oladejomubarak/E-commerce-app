package com.example.ecommercesystem.data.model;

import lombok.Data;

@Data
public class User {
    //private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
}
