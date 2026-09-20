package com.fnb.userManagement.service.serviceImpl;

import com.fnb.userManagement.dto.RegisterRequest;
import com.fnb.userManagement.dto.RegisterResponse;
import com.fnb.userManagement.entity.Role;
import com.fnb.userManagement.entity.User;
import com.fnb.userManagement.entity.UserCredential;
import com.fnb.userManagement.repository.UserCredentialsRepository;
import com.fnb.userManagement.repository.UserRepository;
import com.fnb.userManagement.service.AuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserCredentialsRepository userCredentialsRepository;
    @Override
    @Transactional
    public RegisterResponse register(RegisterRequest registerRequest) {
        User user = User.builder()
                .firstName(registerRequest.getFirstname())
                .surname(registerRequest.getSurname())
                .email(registerRequest.getEmail())
                .role(Role.CUSTOMER)
                .build();
        user = userRepository.save(user);

        UserCredential userCredentials =  UserCredential.builder()
                .user(user)
                .password(registerRequest.getPassword())
                .build();
        userCredentialsRepository.save(userCredentials);

        return toRegisterResponse(user);

    }

    private RegisterResponse toRegisterResponse(User user) {
        return RegisterResponse.builder()
                .customerid(user.getCustomerId())
                .firstName(user.getFirstName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();

    }
}
