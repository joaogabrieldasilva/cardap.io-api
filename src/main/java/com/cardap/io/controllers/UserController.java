package com.cardap.io.controllers;

import com.cardap.io.dtos.res.auth.user.UserResDTO;
import com.cardap.io.models.User;
import com.cardap.io.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserResDTO> getUser(@AuthenticationPrincipal User user) {
        UserResDTO foundUser = userService.getUserByEmail(user.getEmail());

        return ResponseEntity.ok(foundUser);
    }

}
