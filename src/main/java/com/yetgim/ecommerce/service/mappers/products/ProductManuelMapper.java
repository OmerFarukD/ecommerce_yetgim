package com.yetgim.ecommerce.service.mappers.products;

import com.yetgim.ecommerce.dto.products.ProductAddRequestDto;
import com.yetgim.ecommerce.dto.products.ProductResponseDto;
import com.yetgim.ecommerce.dto.products.ProductUpdateRequestDto;
import com.yetgim.ecommerce.entities.Category;
import com.yetgim.ecommerce.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductManuelMapper implements ProductMapperBase{
    @Override
    public Product convertToEntity(ProductAddRequestDto dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setPrice(dto.price());

        product.setStock(dto.stock());
        product.setCategory(new Category(dto.categoryId()));
        return product;
    }

    @Override
    public Product convertToEntity(ProductUpdateRequestDto dto) {
        return null;
    }

    @Override
    public ProductResponseDto convertToResponse(Product product) {
        return null;
    }

    @Override
    public List<ProductResponseDto> convertToResponseList(List<Product> products) {
        return List.of();
    }
}
