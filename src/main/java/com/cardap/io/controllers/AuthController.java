package com.cardap.io.controllers;

import com.cardap.io.dtos.req.auth.SignInReqDTO;
import com.cardap.io.dtos.req.auth.SignUpReqDTO;
import com.cardap.io.dtos.res.auth.AuthResDTO;
import com.cardap.io.exceptions.InvalidEmailOrPasswordException;
import com.cardap.io.exceptions.UserAlreadyExistsException;
import com.cardap.io.models.User;
import com.cardap.io.repositories.UserRepository;
import com.cardap.io.security.TokenService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private PasswordEncoder passwordEncoder;

    private TokenService tokenService;

    private UserRepository userRepository;


    @PostMapping("/sign-in")
    public ResponseEntity<AuthResDTO> signIn(@RequestBody SignInReqDTO body) {

        User user = this.userRepository.findByEmail(body.email()).orElseThrow(InvalidEmailOrPasswordException::new);

        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = tokenService.generateToken(user);

            return ResponseEntity.ok(new AuthResDTO(token));
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/sign-up")
    public ResponseEntity<AuthResDTO> signUp(@RequestBody SignUpReqDTO body) {
        Optional<User> user = this.userRepository.findByEmail(body.email());

        if (user.isPresent()) {
            throw new UserAlreadyExistsException();
        }

        User newUser = new User();
        newUser.setName(body.name());
        newUser.setEmail(body.email());
        newUser.setPhone(body.phone());
        newUser.setPassword(passwordEncoder.encode(body.password()));

        userRepository.save(newUser);

        String token = tokenService.generateToken(newUser);

        return ResponseEntity.ok(new AuthResDTO(token));
    }

}
