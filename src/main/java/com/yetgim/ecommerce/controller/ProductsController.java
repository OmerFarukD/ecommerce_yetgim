package com.yetgim.ecommerce.controller;

import com.yetgim.ecommerce.entities.Product;
import com.yetgim.ecommerce.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")

// http://localhost:8080/api/products
public class ProductsController {





    // select  * from products where Price Between 20000 and 50000

    @GetMapping("/getall")
    public List<Product> getProducts() {
        return new ArrayList<>();
    }

}
