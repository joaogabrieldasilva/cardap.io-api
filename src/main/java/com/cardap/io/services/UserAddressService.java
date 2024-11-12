package com.cardap.io.services;

import com.cardap.io.dtos.req.userAddress.CreateUserAddressReqDTO;
import com.cardap.io.dtos.res.userAddress.UserAddressResDTO;

public interface UserAddressService {

  UserAddressResDTO createUserAddress(Long userId, CreateUserAddressReqDTO dto);
}
