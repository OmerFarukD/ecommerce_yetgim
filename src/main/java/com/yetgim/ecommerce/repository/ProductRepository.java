package com.yetgim.ecommerce.repository;

import com.yetgim.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product,Integer> {

    List<Product> findAllByPriceBetween(double min, double max);

    @Query("from Product where  price <=:max and  price>=:min")
    List<Product> findAllByPriceBetween2(double min, double max);

    List<Product> findAllByNameContains(String name);

    boolean existsByName(String name);

    List<Product> findAllByStockBetween(int min, int max);


    List<Product> findAllByCategory_IdAndPriceBetween(int categoryId,double min, double max);


    // jpql
    @Query("from Product where name  like concat('%', :name, '%')")
    List<Product> findAllByNameContains2(String name);

    boolean existsById(int id);

    List<Product> getAllByCategory_Name(String categoryName);

}
