package com.yetgim.ecommerce.service.abstracts;

import com.yetgim.ecommerce.entities.Cart;

public interface CartService {

    void createCart(Long userId);

    Long getCartId(Long userId);

    Cart getCart(Long userId);

}
