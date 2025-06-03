package com.yetgim.ecommerce.dto.carts;

import com.yetgim.ecommerce.entities.Cart;
import com.yetgim.ecommerce.entities.CartItem;
import com.yetgim.ecommerce.entities.Product;

public record CartItemAddRequestDto(
        Integer productId,
        int quantity
) {
    public  static CartItem convertToEntity(CartItemAddRequestDto dto){
        Product product = new Product();
        product.setId(dto.productId);
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(dto.quantity);

        return cartItem;
    }
}
