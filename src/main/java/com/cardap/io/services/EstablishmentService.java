package com.cardap.io.services;

import com.cardap.io.dtos.req.establishment.CreateEstablishmentReqDTO;
import com.cardap.io.dtos.req.establishment.UpdateEstablishmentReqDTO;
import com.cardap.io.dtos.res.establishment.EstablishmentResDTO;

public interface EstablishmentService {

    EstablishmentResDTO create(Long responsibleId, CreateEstablishmentReqDTO dto);

    EstablishmentResDTO update(Long establishmentId,UpdateEstablishmentReqDTO dto);

    EstablishmentResDTO findById(Long id);

    void deleteById(Long id);
}
