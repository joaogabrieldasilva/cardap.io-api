package com.cardap.io.controllers;

import com.cardap.io.dtos.req.establishment.CreateEstablishmentReqDTO;
import com.cardap.io.dtos.req.establishment.UpdateEstablishmentReqDTO;
import com.cardap.io.dtos.res.product.ProductResDTO;
import com.cardap.io.dtos.res.establishment.EstablishmentResDTO;
import com.cardap.io.models.User;
import com.cardap.io.services.EstablishmentService;
import com.cardap.io.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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

    private ProductService productService;

    @GetMapping("/{establishmentId}")
    public ResponseEntity<EstablishmentResDTO> findEstablishmentById(@PathVariable Long establishmentId){
        return ResponseEntity.ok(establishmentService.findById(establishmentId));
    }

    @PostMapping
    public ResponseEntity<EstablishmentResDTO> createEstablishment(@AuthenticationPrincipal User user, @Valid @RequestBody CreateEstablishmentReqDTO body) {
        return new ResponseEntity<>(establishmentService.create(user.getId(), body), HttpStatus.CREATED);
    }

    @PutMapping("{establishmentId}")
    public ResponseEntity<EstablishmentResDTO> updateEstablishment(@PathVariable Long establishmentId, @Valid @RequestBody UpdateEstablishmentReqDTO body) {
        return ResponseEntity.ok(establishmentService.update(establishmentId, body));
    }

    @DeleteMapping("{establishmentId}")
    public ResponseEntity<?> deleteEstablishment(@PathVariable Long establishmentId) {
        establishmentService.deleteById(establishmentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{establishmentId}/products")
    public ResponseEntity<Collection<ProductResDTO>> getEstablishmentDishes(@PathVariable Long establishmentId) {
        return ResponseEntity.ok(productService.getEstablishmentDishes(establishmentId));
    }

}