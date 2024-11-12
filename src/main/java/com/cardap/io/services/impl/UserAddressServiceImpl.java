package com.cardap.io.services.impl;

import com.cardap.io.dtos.req.userAddress.CreateUserAddressReqDTO;
import com.cardap.io.dtos.res.userAddress.UserAddressResDTO;
import com.cardap.io.exceptions.UserNotFoundException;
import com.cardap.io.models.User;
import com.cardap.io.models.UserAddress;
import com.cardap.io.repositories.UserAddressRepository;
import com.cardap.io.repositories.UserRepository;
import com.cardap.io.services.UserAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserAddressServiceImpl implements UserAddressService {

  private UserAddressRepository userAddressRepository;

  private UserRepository userRepository;


  @Override
  public UserAddressResDTO createUserAddress(Long userId, CreateUserAddressReqDTO dto) {

    User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);

    UserAddress createdAddress = userAddressRepository.save(
            UserAddress.builder()
                    .name(dto.name())
                    .street(dto.street())
                    .state(dto.state())
                    .user(user)
                    .country(dto.country())
                    .zipCode(dto.zipCode())
                    .number(dto.number())
                    .complement(dto.complement().orElse(null))
                    .reference(dto.reference().orElse(null)).build()
    );

    return new UserAddressResDTO(
            createdAddress.getId(),
            createdAddress.getName(),
            createdAddress.getStreet(),
            createdAddress.getState(),
            createdAddress.getCountry(),
            createdAddress.getZipCode(),
            createdAddress.getNumber(),
            Optional.ofNullable(createdAddress.getComplement()),
            Optional.ofNullable(createdAddress.getReference())
    );
  }
}
