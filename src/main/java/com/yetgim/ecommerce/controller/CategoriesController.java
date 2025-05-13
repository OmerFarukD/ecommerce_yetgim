package com.yetgim.ecommerce.controller;

import com.yetgim.ecommerce.entities.Category;
import com.yetgim.ecommerce.service.abstracts.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoriesController {


    private final CategoryService categoryService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {

        List<Category> categories = categoryService.getAll();
        return  ResponseEntity.ok(categories);

    }


}
