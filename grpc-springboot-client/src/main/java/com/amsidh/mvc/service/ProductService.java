package com.amsidh.mvc.service;

import com.amsidh.mvc.model.*;

public interface ProductService {
    ProductResponse addProduct(ProductRequest productRequest);

    ProductResponse getProductById(ProductIdRequest productIdRequest);

    AllProductsResponse getAllProduct(NoParam noParam);

}
