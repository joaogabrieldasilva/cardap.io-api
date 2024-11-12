package com.cardap.io.dtos.req.establishment;

import com.cardap.io.dtos.req.establishmentAddress.CreateEstablishmentAddressReqDTO;

public record CreateEstablishmentReqDTO(String name, CreateEstablishmentAddressReqDTO address, String phone, Long responsibleId) {
}
