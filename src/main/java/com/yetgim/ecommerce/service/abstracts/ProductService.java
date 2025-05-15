package com.yetgim.ecommerce.service.abstracts;

import com.yetgim.ecommerce.dto.products.ProductAddRequestDto;
import com.yetgim.ecommerce.dto.products.ProductResponseDto;
import com.yetgim.ecommerce.dto.products.ProductUpdateRequestDto;

import java.util.List;

public interface ProductService {

    void  add(ProductAddRequestDto dto);
    void  update(ProductUpdateRequestDto dto);
    List<ProductResponseDto> getAll();
    ProductResponseDto getBById(int id);
    void delete(int id);
}
