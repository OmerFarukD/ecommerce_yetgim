package com.yetgim.ecommerce.service.abstracts;

import com.yetgim.ecommerce.dto.products.ProductAddRequestDto;
import com.yetgim.ecommerce.dto.products.ProductResponseDto;
import com.yetgim.ecommerce.dto.products.ProductUpdateRequestDto;
import com.yetgim.ecommerce.entities.Product;

import java.util.List;

public interface ProductService {

    void  add(ProductAddRequestDto dto);
    void  update(ProductUpdateRequestDto dto);
    List<ProductResponseDto> getAll();
    ProductResponseDto getById(int id);
    void delete(int id);
    List<Product> getAllData();
    List<ProductResponseDto> getAllByNameContains(String  name);
    List<ProductResponseDto> getAllByPriceRange(double min, double max);
    List<ProductResponseDto> getAllByStockRange(int min, int max);
    List<ProductResponseDto> getAllByCategoryIdAndPriceRange(int categoryId, double min, double max);
    List<ProductResponseDto> getAllByCategoryName(String name);


}
