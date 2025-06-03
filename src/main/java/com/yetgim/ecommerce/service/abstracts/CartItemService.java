package com.yetgim.ecommerce.service.abstracts;

import com.yetgim.ecommerce.dto.carts.CartItemAddRequestDto;
import com.yetgim.ecommerce.dto.carts.CartItemResponseDto;

import java.util.List;

public interface CartItemService {

    void AddCart(CartItemAddRequestDto dto);
    void DeleteCartItem(Long id);
    List<CartItemResponseDto> getAllCartByCurrentUser();
}
