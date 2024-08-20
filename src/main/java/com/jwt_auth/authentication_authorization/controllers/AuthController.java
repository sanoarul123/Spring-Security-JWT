package com.jwt_auth.authentication_authorization.controllers;

import com.jwt_auth.authentication_authorization.dtos.AuthService;
import com.jwt_auth.authentication_authorization.dtos.JwtDto;
import com.jwt_auth.authentication_authorization.dtos.SignInDto;
import com.jwt_auth.authentication_authorization.dtos.SignUpDto;
import com.jwt_auth.authentication_authorization.exceptions.InvalidJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpDto signUpDto) {
        try {
            authService.signUp(signUpDto);
            return ResponseEntity.ok("User registered successfully");
        } catch (InvalidJwtException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtDto> signIn(@RequestBody SignInDto signInDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInDto.login(), signInDto.password()));
        // Generate JWT token and return it
        // ...
        return ResponseEntity.ok(new JwtDto("generated-token", "Bearer"));
    }
}