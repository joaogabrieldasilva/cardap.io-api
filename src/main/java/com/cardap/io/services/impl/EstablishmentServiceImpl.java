package com.cardap.io.services.impl;

import com.cardap.io.dtos.req.establishment.CreateEstablishmentReqDTO;
import com.cardap.io.dtos.req.establishment.UpdateEstablishmentReqDTO;
import com.cardap.io.dtos.req.establishmentAddress.CreateEstablishmentAddressReqDTO;
import com.cardap.io.dtos.res.establishment.EstablishmentResDTO;
import com.cardap.io.exceptions.EstablishmentNotFoundException;
import com.cardap.io.exceptions.UserNotFoundException;
import com.cardap.io.models.Establishment;
import com.cardap.io.models.EstablishmentAddress;
import com.cardap.io.models.User;
import com.cardap.io.repositories.EstablishmentAddressRepository;
import com.cardap.io.repositories.EstablishmentRepository;
import com.cardap.io.repositories.UserRepository;
import com.cardap.io.services.EstablishmentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstablishmentServiceImpl implements EstablishmentService {

  private EstablishmentRepository establishmentRepository;

  private UserRepository userRepository;

  private EstablishmentAddressRepository establishmentAddressRepository;

  @Override
  @Transactional
  public EstablishmentResDTO create(Long responsibleId, CreateEstablishmentReqDTO dto) {

    User responsible = userRepository.findById(responsibleId).orElseThrow(UserNotFoundException::new);


    Establishment establishment = Establishment.builder()
            .name(dto.name())
            .phone(dto.phone())
            .responsible(responsible)
            .build();

    Establishment createdEstablishment = establishmentRepository.save(establishment);

    CreateEstablishmentAddressReqDTO addressReqDTO = dto.address();

    establishmentAddressRepository.save(
            EstablishmentAddress.builder()
                    .establishment(establishment)
                    .name(addressReqDTO.name())
                    .street(addressReqDTO.street())
                    .state(addressReqDTO.state())
                    .country(addressReqDTO.country())
                    .zipCode(addressReqDTO.zipCode())
                    .number(addressReqDTO.number())
                    .complement(addressReqDTO.complement().orElse(null))
                    .reference(addressReqDTO.reference().orElse(null))
                    .build()
    );

    return new EstablishmentResDTO(createdEstablishment.getId(), createdEstablishment.getName(), createdEstablishment.getPhone());
  }

  @Override
  public EstablishmentResDTO update(Long establishmentId, UpdateEstablishmentReqDTO dto) {

    Establishment establishment = establishmentRepository.findById(establishmentId).orElseThrow(EstablishmentNotFoundException::new);

    dto.name().ifPresent(establishment::setName);
    dto.phone().ifPresent(establishment::setPhone);

    return new EstablishmentResDTO(
            establishment.getId(),
            establishment.getName(),
            establishment.getPhone()
    );
  }

  @Override
  public EstablishmentResDTO findById(Long id) {
    Establishment establishment = establishmentRepository.findById(id).orElseThrow(EstablishmentNotFoundException::new);

    return new EstablishmentResDTO(
            establishment.getId(),
            establishment.getName(),
            establishment.getPhone()
    );
  }

  @Override
  public void deleteById(Long id) {
    establishmentRepository.deleteById(id);
  }
}
