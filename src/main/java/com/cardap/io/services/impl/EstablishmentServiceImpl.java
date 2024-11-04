package com.cardap.io.services.impl;

import com.cardap.io.dtos.req.establishment.CreateEstablishmentReqDTO;
import com.cardap.io.dtos.req.establishment.UpdateEstablishmentReqDTO;
import com.cardap.io.dtos.res.establishment.EstablishmentResDTO;
import com.cardap.io.exceptions.EstablishmentNotFoundException;
import com.cardap.io.exceptions.UserNotFoundException;
import com.cardap.io.models.Establishment;
import com.cardap.io.models.User;
import com.cardap.io.repositories.EstablishmentRepository;
import com.cardap.io.repositories.UserRepository;
import com.cardap.io.services.EstablishmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstablishmentServiceImpl implements EstablishmentService {

    private EstablishmentRepository establishmentRepository;

    private UserRepository userRepository;

    @Override
    public EstablishmentResDTO create(Long responsibleId, CreateEstablishmentReqDTO dto) {

        User responsible = userRepository.findById(responsibleId).orElseThrow(UserNotFoundException::new);

        Establishment establishment = Establishment.builder()
                .name(dto.name())
                .address(dto.address())
                .phone(dto.phone())
                .responsible(responsible)
                .build();

        Establishment createdEstablishment = establishmentRepository.save(establishment);

        return new EstablishmentResDTO((long) createdEstablishment.getId(), createdEstablishment.getName(), createdEstablishment.getAddress(), createdEstablishment.getPhone());
    }

    @Override
    public EstablishmentResDTO update(Long establishmentId, UpdateEstablishmentReqDTO dto) {

        Establishment establishment = establishmentRepository.findById(establishmentId).orElseThrow(EstablishmentNotFoundException::new);

        dto.name().ifPresent(establishment::setName);
        dto.phone().ifPresent(establishment::setPhone);
        dto.address().ifPresent(establishment::setAddress);

        return new EstablishmentResDTO(
                establishment.getId(),
                establishment.getName(),
                establishment.getAddress(),
                establishment.getPhone()
        );
    }

    @Override
    public EstablishmentResDTO findById(Long id) {
        Establishment establishment = establishmentRepository.findById(id).orElseThrow(EstablishmentNotFoundException::new);

        return new EstablishmentResDTO(
                establishment.getId(),
                establishment.getName(),
                establishment.getAddress(),
                establishment.getPhone()
        );
    }

    @Override
    public void deleteById(Long id) {
        establishmentRepository.deleteById(id);
    }
}
