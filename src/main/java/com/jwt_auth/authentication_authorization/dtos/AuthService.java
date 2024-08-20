package com.jwt_auth.authentication_authorization.dtos;

import com.jwt_auth.authentication_authorization.entities.User;
import com.jwt_auth.authentication_authorization.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.jwt_auth.authentication_authorization.exceptions.InvalidJwtException;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return repository.findByLogin(username);
    }

    public UserDetails signUp(SignUpDto data) throws InvalidJwtException {
        if (repository.findByLogin(data.login()) != null) {
            throw new InvalidJwtException("Username already exists");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());
        return repository.save(newUser);
    }
}