package com.fnb.userManagement.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponse {

    private Long customerid;

    private String firstName;

    private String surname;

    private String email;

    private String role;
}
