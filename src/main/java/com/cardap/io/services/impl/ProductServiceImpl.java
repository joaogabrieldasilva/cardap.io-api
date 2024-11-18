package com.cardap.io.services.impl;

import com.cardap.io.dtos.req.product.CreateProductReqDTO;
import com.cardap.io.dtos.req.product.UpdateProductReqDTO;
import com.cardap.io.dtos.res.product.ProductResDTO;
import com.cardap.io.exceptions.ProductNotFoundException;
import com.cardap.io.exceptions.EstablishmentNotFoundException;
import com.cardap.io.models.Product;
import com.cardap.io.models.Establishment;
import com.cardap.io.models.Ingredient;
import com.cardap.io.repositories.ProductRepository;
import com.cardap.io.repositories.EstablishmentRepository;
import com.cardap.io.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;

  private EstablishmentRepository establishmentRepository;

  @Override
  public Collection<ProductResDTO> getEstablishmentDishes(Long establishmentId) {
    return productRepository.findProductByEstablishmentId(establishmentId).stream().map(dish -> new ProductResDTO(dish.getId(), dish.getName(), dish.getDescription(), dish.getPrice())).toList();
  }

  @Override
  public ProductResDTO createProduct(CreateProductReqDTO dto) {

    Establishment establishment = establishmentRepository.findById(dto.establishmentId()).orElseThrow(EstablishmentNotFoundException::new);


    Collection<Ingredient> ingredients = dto.ingredients().stream().map(ingredient -> Ingredient.builder()
            .name(ingredient.name())
            .build()
    ).toList();

    Product product = Product.builder()
            .name(dto.name())
            .description(dto.description())
            .price(dto.price())
            .establishment(establishment)
            .ingredients(ingredients)
            .build();

    ingredients.forEach(ingredient -> ingredient.setProduct(product));

    Product createdProduct = productRepository.save(product);

    return new ProductResDTO(createdProduct.getId(), createdProduct.getName(), createdProduct.getDescription(), createdProduct.getPrice());
  }

  @Override
  public ProductResDTO updateProduct(Long dishId, UpdateProductReqDTO dto) {

    Product product = productRepository.findById(dishId).orElseThrow(ProductNotFoundException::new);

    dto.name().ifPresent(product::setName);
    dto.description().ifPresent(product::setDescription);
    dto.price().ifPresent(product::setPrice);

    productRepository.save(product);

    return new ProductResDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice());
  }
}
