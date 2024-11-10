package com.cardap.io.services;

import com.cardap.io.dtos.req.product.CreateProductReqDTO;
import com.cardap.io.dtos.req.product.UpdateProductReqDTO;
import com.cardap.io.dtos.res.product.ProductResDTO;

import java.util.Collection;

public interface ProductService {

    Collection<ProductResDTO> getEstablishmentDishes(Long establishmentId);

    ProductResDTO createProduct(CreateProductReqDTO dto);

    ProductResDTO updateProduct(Long dishId, UpdateProductReqDTO dto);
}
