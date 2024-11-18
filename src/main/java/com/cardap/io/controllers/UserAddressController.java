package com.cardap.io.controllers;

import com.cardap.io.dtos.req.userAddress.CreateUserAddressReqDTO;
import com.cardap.io.dtos.res.userAddress.UserAddressResDTO;
import com.cardap.io.models.User;
import com.cardap.io.services.UserAddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-addresses")
@AllArgsConstructor
public class UserAddressController {

  private UserAddressService userAddressService;

  @PostMapping
  public ResponseEntity<UserAddressResDTO> createUserAddress(@AuthenticationPrincipal User user, @Valid @RequestBody CreateUserAddressReqDTO body) {

    UserAddressResDTO userAddressResDTO = userAddressService.createUserAddress(user.getId(), body);

    return ResponseEntity.ok(userAddressResDTO);
  }
}
