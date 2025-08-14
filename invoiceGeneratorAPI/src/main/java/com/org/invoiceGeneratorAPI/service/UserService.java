package com.org.invoiceGeneratorAPI.service;

import com.org.invoiceGeneratorAPI.repository.UserRepository;
import com.org.invoiceGeneratorAPI.entity.Users;
import com.org.invoiceGeneratorAPI.dto.LoginRequest;
import com.org.invoiceGeneratorAPI.dto.SignupRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Map<String, String> signUp(SignupRequest signupRequest) {
        Map<String, String> response = new HashMap<>();

        if (userRepository.existsByEmailId(signupRequest.getEmailId())) {
            response.put("message", "Email Already Exists");
            return response;
        }

        Users user = new Users();
        user.setEmailId(signupRequest.getEmailId());
        user.setName(signupRequest.getName());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setPhoneNumber(signupRequest.getPhoneNumber());

        userRepository.save(user);

        response.put("message", "Signup Successful");
        return response;
    }

    public Map<String, String> logIn(LoginRequest loginRequest) {
        Map<String, String> response = new HashMap<>();

        Users user = userRepository.findByEmailId(loginRequest.getEmailId()).orElse(null);
        if (user == null || !passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            response.put("message", "Invalid Email / Password");
            return response;
        }

        response.put("message", "Login Successful");
        return response;
    }
}
