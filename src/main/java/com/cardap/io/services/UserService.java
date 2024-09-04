package com.cardap.io.services;

import com.cardap.io.dtos.res.auth.user.UserResDTO;

public interface UserService {

    UserResDTO getUserByEmail(String email);
}
