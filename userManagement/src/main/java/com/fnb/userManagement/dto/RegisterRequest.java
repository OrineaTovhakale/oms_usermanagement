package com.fnb.userManagement.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String firstname;

    private String surname;

    private String email;

    private String password;


}
