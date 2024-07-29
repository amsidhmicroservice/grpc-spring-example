package com.amsidh.mvc.mapper;

import com.amsidh.mvc.model.ProductRequest;
import com.amsidh.mvc.model.ProductRequestDto;
import com.amsidh.mvc.model.ProductResponse;
import com.amsidh.mvc.model.ProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


    ProductRequestDto productRequestToProductRequestDto(ProductRequest productRequest);
    ProductRequest productRequestDtoToProductRequest(ProductRequestDto productRequestDto);


    ProductResponseDto productResponseToProductResponseDto(ProductResponse productResponse);

    ProductResponse productResponseDtoToProductResponse(ProductResponseDto productResponseDto);

}
