package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.handler.ProductRequestHandler;
import com.amsidh.mvc.model.*;
import com.amsidh.mvc.service.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@RequiredArgsConstructor
@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductRequestHandler productRequestHandler;

    @Override
    public void getProduct(ProductIdRequest request, StreamObserver<ProductResponse> responseObserver) {
        responseObserver.onNext(productRequestHandler.getProduct(request));
        responseObserver.onCompleted();
    }

    @Override
    public void addProduct(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        responseObserver.onNext(productRequestHandler.addProduct(request));
        responseObserver.onCompleted();
    }

    @Override
    public void getAllProduct(NoParam request, StreamObserver<AllProductsResponse> responseObserver) {
        responseObserver.onNext(productRequestHandler.getAllProduct(request));
        responseObserver.onCompleted();
    }
}
