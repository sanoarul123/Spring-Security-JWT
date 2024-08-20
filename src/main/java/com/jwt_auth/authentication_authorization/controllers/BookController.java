package com.jwt_auth.authentication_authorization.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BookController {
    @GetMapping
    public ResponseEntity<List<String>> findAll() {
        return ResponseEntity.ok(List.of("Book1", "Book2", "Book3"));
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody String data) {
        return ResponseEntity.ok(data);
    }
}
