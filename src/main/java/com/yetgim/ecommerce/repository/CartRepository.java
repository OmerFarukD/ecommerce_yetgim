package com.yetgim.ecommerce.repository;

import com.yetgim.ecommerce.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {

    boolean existsByUser_Id(Long userId);

    Optional<Cart> findByUser_Id(Long userId);
}
