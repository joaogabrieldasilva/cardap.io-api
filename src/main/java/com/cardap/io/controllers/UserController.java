package com.cardap.io.controllers;

import com.cardap.io.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    @GetMapping
    public ResponseEntity<String> getUser() {
            return ResponseEntity.ok("OK");
    }

}
