package com.yetgim.ecommerce.controller;
import com.yetgim.ecommerce.dto.categories.CategoryAddRequestDto;
import com.yetgim.ecommerce.dto.categories.CategoryResponseDto;
import com.yetgim.ecommerce.dto.categories.CategoryUpdateRequestDto;
import com.yetgim.ecommerce.service.abstracts.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<?> getById(@RequestParam int id)  {
            CategoryResponseDto response = categoryService.getById(id);
            return ResponseEntity.ok(response);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        categoryService.delete(id);
        return ResponseEntity.ok("Category Deleted");
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody CategoryAddRequestDto dto){
            categoryService.add(dto);
            return ResponseEntity.ok("Category Added.");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody CategoryUpdateRequestDto dto){
            categoryService.update(dto);
            return ResponseEntity.ok("Category Modified.");
    }
}
