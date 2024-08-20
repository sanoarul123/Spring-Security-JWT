package com.jwt_auth.authentication_authorization.config;

public class JwtProperties {
    private TokenProperties token = new TokenProperties();

    public TokenProperties getToken() {
        return token;
    }

    public void setToken(TokenProperties token) {
        this.token = token;
    }

    public static class TokenProperties {
        private String secretKey;

        public String getSecretKey() {
            return secretKey;
        }

        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }
    }
}