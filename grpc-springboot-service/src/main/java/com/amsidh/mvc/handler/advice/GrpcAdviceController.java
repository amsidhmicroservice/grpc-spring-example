package com.amsidh.mvc.handler.advice;

import com.amsidh.mvc.exception.ProductNotFoundException;
import io.grpc.Status;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class GrpcAdviceController {

    @GrpcExceptionHandler({ProductNotFoundException.class})
    public Status handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        return Status.NOT_FOUND.withDescription(productNotFoundException.getMessage());
    }


}
