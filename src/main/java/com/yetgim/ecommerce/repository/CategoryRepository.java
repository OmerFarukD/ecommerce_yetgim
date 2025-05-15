package com.yetgim.ecommerce.repository;

import com.yetgim.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

    // SELECT * FROM Categories where Name = 'deneme'

    @Query("FROM  Category where name=:name")
    Optional<Category> getByCategoryName(String  name);

}
