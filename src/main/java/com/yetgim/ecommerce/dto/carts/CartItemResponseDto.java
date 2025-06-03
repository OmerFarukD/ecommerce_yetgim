package com.yetgim.ecommerce.dto.carts;

import com.yetgim.ecommerce.dto.products.ProductCartItemResponseDto;
import com.yetgim.ecommerce.dto.products.ProductResponseDto;
import com.yetgim.ecommerce.entities.CartItem;

public record CartItemResponseDto(
        Long id,
        ProductCartItemResponseDto productResponseDto,
        int quantity,
        Long cartId
        ) {

    public  static  CartItemResponseDto covertToResponseDto(CartItem cartItem){
        ProductCartItemResponseDto responseDto = ProductCartItemResponseDto
                .convertToResponse(cartItem.getProduct());


        CartItemResponseDto cartItemResponseDto = new CartItemResponseDto
                (cartItem.getId(),responseDto, cartItem.getQuantity(), cartItem.getCart().getId());

        return  cartItemResponseDto;
    }

}
