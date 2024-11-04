package com.cardap.io.services;

import com.cardap.io.dtos.res.user.UserResDTO;

public interface UserService {

    UserResDTO getUserByEmail(String email);
}
