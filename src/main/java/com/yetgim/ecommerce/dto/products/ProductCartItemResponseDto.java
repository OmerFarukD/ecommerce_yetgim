package com.yetgim.ecommerce.dto.products;

import com.yetgim.ecommerce.entities.Product;

public record ProductCartItemResponseDto(Integer id, String name, double price) {


    public  static ProductCartItemResponseDto convertToResponse(Product product){

        return new ProductCartItemResponseDto(product.getId(),product.getName(), product.getPrice());
    }
}
