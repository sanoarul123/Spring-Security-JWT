package com.jwt_auth.authentication_authorization.dtos;

import com.jwt_auth.authentication_authorization.enums.UserRole;

public record SignUpDto(
        String login,
        String password,
        UserRole role) {
}