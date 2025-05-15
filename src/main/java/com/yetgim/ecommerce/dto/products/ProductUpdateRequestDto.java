package com.yetgim.ecommerce.dto.products;

public record ProductUpdateRequestDto(Integer id,String name,double price,int stock,Integer categoryId) {
}
