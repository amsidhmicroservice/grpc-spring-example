package com.amsidh.mvc.exception;

public class ProductNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Product with id [id=%d] not found";

    public ProductNotFoundException(Integer productId) {
        super(MESSAGE.formatted(productId));
    }
}
