package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.model.*;
import com.amsidh.mvc.service.ProductService;
import com.amsidh.mvc.service.ProductServiceGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @GrpcClient("product-service")
    private ProductServiceGrpc.ProductServiceBlockingStub productClient;

    @Override
    public ProductResponse addProduct(ProductRequest addProductRequest) {
        log.info("Add Product Request {}", addProductRequest);
        final ProductResponse addProductResponse = this.productClient.addProduct(addProductRequest);
        log.info("Add Product Response {}", addProductResponse);
        return addProductResponse;
    }

    @Override
    public ProductResponse getProductById(ProductIdRequest productIdRequest) {
        log.info("Product ID Request {}", productIdRequest);
        final ProductResponse productIdResponse = this.productClient.getProduct(productIdRequest);
        log.info("Product ID Response {}", productIdResponse);
        return productIdResponse;
    }

    @Override
    public AllProductsResponse getAllProduct(NoParam noParamRequest) {
        log.info("No Param Request to get all Products {}", noParamRequest);
        AllProductsResponse allProductsResponse = this.productClient.getAllProduct(noParamRequest);
        log.info("All Product Response {}", allProductsResponse);
        return allProductsResponse;
    }
}
