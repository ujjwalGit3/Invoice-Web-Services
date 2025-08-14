package com.org.invoiceGeneratorAPI.controller;

import com.org.invoiceGeneratorAPI.dto.LoginRequest;
import com.org.invoiceGeneratorAPI.dto.SignupRequest;
import com.org.invoiceGeneratorAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/authentication")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> signUp(@RequestBody SignupRequest signupRequest) {
        Map<String, String> result = userService.signUp(signupRequest);

        if ("Email Already Exists".equals(result.get("message"))) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result); // 409 Conflict
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result); // 201 Created
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {
        Map<String, String> result = userService.logIn(loginRequest);

        if ("Invalid Email / Password".equals(result.get("message"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result); // 401 Unauthorized
        }
        return ResponseEntity.ok(result); // 200 OK
    }
}
