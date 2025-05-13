package com.yetgim.ecommerce.service.abstracts;

import com.yetgim.ecommerce.dto.categories.CategoryAddRequestDto;
import com.yetgim.ecommerce.dto.categories.CategoryResponseDto;
import com.yetgim.ecommerce.dto.categories.CategoryUpdateRequestDto;
import com.yetgim.ecommerce.entities.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> getAll();
    CategoryResponseDto getById(int id);
    void  add(CategoryAddRequestDto dto);
    void update(CategoryUpdateRequestDto dto);
    void delete(int id);

}
