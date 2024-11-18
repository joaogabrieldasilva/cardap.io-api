package com.cardap.io.controllers;

import com.cardap.io.dtos.req.product.CreateProductReqDTO;
import com.cardap.io.dtos.req.product.UpdateProductReqDTO;
import com.cardap.io.dtos.res.product.ProductResDTO;
import com.cardap.io.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResDTO> createProduct(@Valid @RequestBody CreateProductReqDTO dto) {
        return new ResponseEntity<ProductResDTO>(productService.createProduct(dto), HttpStatus.CREATED);
    }

    @PutMapping("{productId}")
    public ResponseEntity<ProductResDTO> createProduct(@PathVariable Long productId, @Valid @RequestBody UpdateProductReqDTO dto) {
        return ResponseEntity.ok(productService.updateProduct(productId, dto));
    }

}
