package com.fnb.userManagement.service;

import com.fnb.userManagement.dto.RegisterRequest;
import com.fnb.userManagement.dto.RegisterResponse;


public interface AuthService {

    RegisterResponse register(RegisterRequest registerRequest);


}
