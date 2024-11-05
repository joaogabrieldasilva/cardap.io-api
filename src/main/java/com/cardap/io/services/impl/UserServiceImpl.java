package com.cardap.io.services.impl;

import com.cardap.io.dtos.res.user.UserResDTO;
import com.cardap.io.exceptions.UserNotFoundException;
import com.cardap.io.models.User;
import com.cardap.io.repositories.UserRepository;
import com.cardap.io.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserResDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);

        return new UserResDTO(user.getName(), user.getEmail(), user.getPhone());
    }
}
