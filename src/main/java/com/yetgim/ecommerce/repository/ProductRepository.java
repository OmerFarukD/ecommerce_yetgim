package com.yetgim.ecommerce.repository;

import com.yetgim.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product,Integer> {

    List<Product> findAllByPriceBetween(double min, double max);

}
