package com.cardap.io.controllers;

import com.cardap.io.dtos.req.establishment.CreateEstablishmentReqDTO;
import com.cardap.io.dtos.req.establishment.UpdateEstablishmentReqDTO;
import com.cardap.io.dtos.res.dish.DishResDTO;
import com.cardap.io.dtos.res.establishment.EstablishmentResDTO;
import com.cardap.io.models.User;
import com.cardap.io.services.DishService;
import com.cardap.io.services.EstablishmentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/establishments")
@AllArgsConstructor
public class EstablishmentController {


    private EstablishmentService establishmentService;

    private DishService dishService;


    @GetMapping("/{establishmentId}")
    public ResponseEntity<EstablishmentResDTO> findEstablishmentById(@PathVariable Long establishmentId){
        return ResponseEntity.ok(establishmentService.findById(establishmentId));
    };

    @PostMapping
    public ResponseEntity<EstablishmentResDTO> createEstablishment(@AuthenticationPrincipal User user, @RequestBody CreateEstablishmentReqDTO body) {
        return new ResponseEntity<EstablishmentResDTO>(establishmentService.create(user.getId(), body), HttpStatus.CREATED);
    }

    @PutMapping("{establishmentId}")
    public ResponseEntity<EstablishmentResDTO> updateEstablishment(@PathVariable Long establishmentId, @RequestBody UpdateEstablishmentReqDTO body) {
        return ResponseEntity.ok(establishmentService.update(establishmentId, body));
    }

    @DeleteMapping("{establishmentId}")
    public ResponseEntity<?> deleteEstablishment(@PathVariable Long establishmentId) {
        establishmentService.deleteById(establishmentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{establishmentId}/dishes")
    public ResponseEntity<Collection<DishResDTO>> getEstablishmentDishes(@PathVariable Long establishmentId) {
        return ResponseEntity.ok(dishService.getEstablishmentDishes(establishmentId));
    }
}
