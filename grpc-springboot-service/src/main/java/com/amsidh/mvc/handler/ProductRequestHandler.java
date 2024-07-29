package com.amsidh.mvc.handler;

import com.amsidh.mvc.exception.ProductNotFoundException;
import com.amsidh.mvc.model.*;
import com.amsidh.mvc.repository.ProductRepository;
import com.amsidh.mvc.repository.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Component
public class ProductRequestHandler {
    private final ProductRepository productRepository;

    public ProductResponse getProduct(ProductIdRequest productIdRequest) {

        ProductEntity productEntity = productRepository.findById(productIdRequest.getId()).orElseThrow(() -> new ProductNotFoundException(productIdRequest.getId()));
        return ProductResponse.newBuilder()
                .setId(productEntity.getId())
                .setPrice(productEntity.getPrice())
                .setDescription(productEntity.getDescription())
                .build();
    }


    public ProductResponse addProduct(ProductRequest productRequest) {
        ProductEntity productEntity = productRepository.save(ProductEntity.builder().id(productRequest.getId()).price(productRequest.getPrice()).description(productRequest.getDescription()).build());
        return ProductResponse.newBuilder().setId(productEntity.getId()).setPrice(productEntity.getPrice()).setDescription(productEntity.getDescription()).build();
    }

    public AllProductsResponse getAllProduct(NoParam request) {
        final Set<ProductResponse> collect = productRepository.findAll().stream().map(productEntity -> ProductResponse.newBuilder()
                .setId(productEntity.getId())
                .setPrice(productEntity.getPrice())
                .setDescription(productEntity.getDescription())
                .build()).collect(Collectors.toSet());
        return AllProductsResponse.newBuilder().addAllProductResponse(collect).build();
    }
}
