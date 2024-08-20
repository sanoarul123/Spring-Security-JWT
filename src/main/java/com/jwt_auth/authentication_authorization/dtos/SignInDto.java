package com.jwt_auth.authentication_authorization.dtos;

public record SignInDto(
        String login,
        String password) {
}
