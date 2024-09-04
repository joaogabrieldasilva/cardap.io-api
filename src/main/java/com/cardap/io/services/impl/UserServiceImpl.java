package com.cardap.io.services.impl;

import com.cardap.io.dtos.res.auth.user.UserResDTO;
import com.cardap.io.exceptions.UserNotFoundException;
import com.cardap.io.models.User;
import com.cardap.io.repositories.UserRepository;
import com.cardap.io.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);

        return new UserResDTO(user.getName(), user.getEmail(), user.getPhone());
    }
}
