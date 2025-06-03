package com.yetgim.ecommerce.repository;

import com.yetgim.ecommerce.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
