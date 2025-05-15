package com.yetgim.ecommerce.controller;

import com.yetgim.ecommerce.dto.products.ProductAddRequestDto;
import com.yetgim.ecommerce.entities.Product;
import com.yetgim.ecommerce.repository.ProductRepository;
import com.yetgim.ecommerce.service.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")

// http://localhost:8080/api/products
@RequiredArgsConstructor
public class ProductsController {

private final ProductService productService;



    // select  * from products where Price Between 20000 and 50000

    @GetMapping("/getall")
    public List<Product> getProducts() {
        return new ArrayList<>();
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody ProductAddRequestDto dto){
        productService.add(dto);
        return ResponseEntity.status(HttpStatus.OK).body("Ürün eklendi.");
    }

}
