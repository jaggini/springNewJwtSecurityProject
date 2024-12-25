package com.example.springsecurityJwtProject.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springsecurityJwtProject.exchanges.request.AuthRequest;
import com.example.springsecurityJwtProject.exchanges.request.RegisterRequest;
import com.example.springsecurityJwtProject.exchanges.response.AuthResponse;
import com.example.springsecurityJwtProject.service.AuthService;



@Controller
public class AuthController {

    @Autowired
    AuthService authService;
@Autowired
private UserDetailsService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody AuthRequest request) {
                userDetailsService.loadUserByUsername(request.getEmail());
        return ResponseEntity.ok(authService.login(request));
    }

}
