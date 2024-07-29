package com.amsidh.mvc.controller;

import com.amsidh.mvc.mapper.ProductMapper;
import com.amsidh.mvc.model.*;
import com.amsidh.mvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductResponseDto saveProduct(@RequestBody ProductRequestDto productRequestDto) {
        final ProductRequest productRequest = ProductMapper.INSTANCE.productRequestDtoToProductRequest(productRequestDto);
        return ProductMapper.INSTANCE.productResponseToProductResponseDto(productService.addProduct(productRequest));
    }

    @GetMapping
    public List<ProductResponseDto> getAllProduct() {
        final AllProductsResponse allProduct = productService.getAllProduct(NoParam.newBuilder().build());
        return allProduct.getProductResponseList().stream().map(ProductMapper.INSTANCE::productResponseToProductResponseDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable Integer id) {
        final ProductResponse productById = productService.getProductById(ProductIdRequest.newBuilder().setId(id).build());
        return ProductMapper.INSTANCE.productResponseToProductResponseDto(productById);
    }


}
