package com.yetgim.ecommerce.controller;

import com.yetgim.ecommerce.dto.categories.CategoryAddRequestDto;
import com.yetgim.ecommerce.dto.categories.CategoryResponseDto;
import com.yetgim.ecommerce.dto.categories.CategoryUpdateRequestDto;
import com.yetgim.ecommerce.exceptions.types.BusinessException;
import com.yetgim.ecommerce.exceptions.types.NotFoundException;
import com.yetgim.ecommerce.service.abstracts.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoriesController {


    private final CategoryService categoryService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll()  {
        List<CategoryResponseDto> categories = categoryService.getAll();
        return  ResponseEntity.ok(categories);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getById(@RequestParam int id){

        try{
            CategoryResponseDto response = categoryService.getById(id);
            return ResponseEntity.ok(response);
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        categoryService.delete(id);
        return ResponseEntity.ok("Category Deleted");
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody CategoryAddRequestDto dto){

        try{
            categoryService.add(dto);
            return ResponseEntity.ok("Category Added.");
        }catch (RuntimeException exception){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }


    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody CategoryUpdateRequestDto dto){

        try{
            categoryService.update(dto);
            return ResponseEntity.ok("Category Modified.");
        }

        catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (BusinessException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }


}
