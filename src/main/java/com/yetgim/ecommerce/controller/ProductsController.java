package com.yetgim.ecommerce.controller;

import com.yetgim.ecommerce.dto.products.ProductAddRequestDto;
import com.yetgim.ecommerce.dto.products.ProductResponseDto;
import com.yetgim.ecommerce.dto.products.ProductUpdateRequestDto;
import com.yetgim.ecommerce.entities.Product;
import com.yetgim.ecommerce.repository.ProductRepository;
import com.yetgim.ecommerce.service.abstracts.ProductService;
import jakarta.validation.Valid;
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


    @GetMapping("/getall")
    public ResponseEntity<List<ProductResponseDto>> getProducts() {
        List<ProductResponseDto> responses = this.productService.getAll();
        return ResponseEntity.status(200).body(responses);

    }

    @GetMapping("/data")
    public ResponseEntity<List<Product>> getData() {
        List<Product> responses = this.productService.getAllData();
        return ResponseEntity.status(200).body(responses);

    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@Valid @RequestBody ProductAddRequestDto dto){
        productService.add(dto);
        return ResponseEntity.status(HttpStatus.OK).body("Ürün eklendi.");
    }


    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody ProductUpdateRequestDto dto){
        productService.update(dto);
        return ResponseEntity.status(HttpStatus.OK).body("Ürün güncellendi.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Ürün silindi.");

    }

    @GetMapping("/get")
    public ResponseEntity<ProductResponseDto> getById(@RequestParam int id){
        ProductResponseDto dto = this.productService.getById(id);
        return ResponseEntity.status(200).body(dto);
    }


    @GetMapping("/getallbyname")
    public ResponseEntity<List<ProductResponseDto>> getAllByNameContains(@RequestParam String name){

        List<ProductResponseDto> responses = this.productService.getAllByNameContains(name);
        return ResponseEntity.status(200).body(responses);
    }

    @GetMapping("/getallbyprice")
    public ResponseEntity<List<ProductResponseDto>> getAllByPriceRange(@RequestParam double min, @RequestParam double max){

        List<ProductResponseDto> responses = this.productService.getAllByPriceRange(min,max);
        return ResponseEntity.status(200).body(responses);
    }

    @GetMapping("/getallstock")
    public ResponseEntity<List<ProductResponseDto>> getAllByStockRange(@RequestParam int min, @RequestParam int max){

        List<ProductResponseDto> responses = this.productService.getAllByStockRange(min,max);
        return ResponseEntity.status(200).body(responses);
    }


    @GetMapping("/getallcategoryandprice")
    public ResponseEntity<List<ProductResponseDto>> getAllByCategoryIdAndPriceRange(@RequestParam int categoryId,@RequestParam double min, @RequestParam double max){

        List<ProductResponseDto> responses = this.productService.getAllByCategoryIdAndPriceRange(categoryId,min,max);
        return ResponseEntity.status(200).body(responses);
    }


    @GetMapping("/getallcategory")
    public ResponseEntity<List<ProductResponseDto>> getAllByCategoryName(@RequestParam String name){

        List<ProductResponseDto> responses = this.productService.getAllByCategoryName(name);
        return ResponseEntity.status(200).body(responses);
    }

}
