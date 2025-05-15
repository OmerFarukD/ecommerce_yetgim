package com.yetgim.ecommerce.service.mappers.products;

import com.yetgim.ecommerce.dto.products.ProductAddRequestDto;
import com.yetgim.ecommerce.dto.products.ProductResponseDto;
import com.yetgim.ecommerce.dto.products.ProductUpdateRequestDto;
import com.yetgim.ecommerce.entities.Product;

import java.util.List;

public interface ProductMapperBase {

    Product convertToEntity(ProductAddRequestDto dto);
    Product convertToEntity(ProductUpdateRequestDto dto);
    ProductResponseDto convertToResponse(Product product);
    List<ProductResponseDto> convertToResponseList(List<Product> products);
}
