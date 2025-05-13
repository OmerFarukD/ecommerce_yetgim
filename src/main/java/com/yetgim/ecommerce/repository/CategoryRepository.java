package com.yetgim.ecommerce.repository;

import com.yetgim.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
