package com.amsidh.mvc;

import com.amsidh.mvc.model.*;
import com.amsidh.mvc.service.ProductServiceGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class GrpcSpringbootClientApplication /*implements CommandLineRunner */{

	@GrpcClient("product-service")
	private ProductServiceGrpc.ProductServiceBlockingStub productClient;

	public static void main(String[] args) {
		SpringApplication.run(GrpcSpringbootClientApplication.class, args);
	}

	//@Override
	public void run(String... args) throws Exception {
		addProductRequestClient();
		getProductByIdClient();
		getAllProductClient();
	}

	private void addProductRequestClient() {
		final ProductRequest addProductRequest = ProductRequest.newBuilder().setId(11).setName("Apple").setPrice(250.50).setDescription("It's Apple").build();
		log.info("Add Product Request {}", addProductRequest);
		final ProductResponse addProductResponse = productClient.addProduct(addProductRequest);
		log.info("Add Product Response {}", addProductResponse);

	}

	private void getProductByIdClient() {
		final ProductRequest addProductRequest = ProductRequest.newBuilder().setId(12).setName("Apple12").setPrice(300.50).setDescription("It's Apple").build();
		log.info("Add Product Request {}", addProductRequest);
		final ProductResponse addProductResponse = productClient.addProduct(addProductRequest);
		log.info("Add Product Response {}", addProductResponse);

		final ProductIdRequest productIdRequest = ProductIdRequest.newBuilder().setId(12).build();
		log.info("Product ID Request {}", productIdRequest);
		final ProductResponse productIdResponse = productClient.getProduct(productIdRequest);
		log.info("Product ID Response {}", productIdResponse);
	}

	private void getAllProductClient() {
		final NoParam noParamRequest = NoParam.newBuilder().build();
		log.info("No Param Request to get all Products {}", noParamRequest);
		AllProductsResponse allProductsResponse = productClient.getAllProduct(noParamRequest);
		log.info("All Product Response {}", allProductsResponse);
	}
}
