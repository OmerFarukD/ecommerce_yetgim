package com.yetgim.ecommerce.service.concretes;

import com.yetgim.ecommerce.dto.categories.CategoryAddRequestDto;
import com.yetgim.ecommerce.dto.categories.CategoryResponseDto;
import com.yetgim.ecommerce.dto.categories.CategoryUpdateRequestDto;
import com.yetgim.ecommerce.entities.Category;
import com.yetgim.ecommerce.repository.CategoryRepository;
import com.yetgim.ecommerce.service.abstracts.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.AbstractElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class CategoryManager  implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final AbstractElasticsearchTemplate abstractElasticsearchTemplate;


    @Override
    public List<CategoryResponseDto> getAll() {

        List<CategoryResponseDto> responses = new ArrayList<>();

        List<Category> categories = categoryRepository.findAll();

        for (Category category : categories){
            CategoryResponseDto response = new CategoryResponseDto(category.getId(), category.getName());
            responses.add(response);
        }

        return responses;
    }

    @Override
    public CategoryResponseDto getById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()){
            throw  new RuntimeException("İlgili id değerine göre bir kategori bulunamamıştır.");
        }

        CategoryResponseDto response = new CategoryResponseDto(category.get().getId(), category.get().getName());
        return response;
    }

    @Override
    public void add(CategoryAddRequestDto dto) {
        Category category = new Category();
        category.setName(dto.name());
        this.categoryRepository.save(category);
    }

    @Override
    public void update(CategoryUpdateRequestDto dto) {
        Category category = categoryRepository.findById(dto.id()).orElse(null);
        if(category == null){
            System.out.println("Category not found");
        }
        category.setId(dto.id());
        category.setName(dto.name());
        categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        Category category = this.categoryRepository.findById(id).orElse(null);

        if (category == null){
            System.out.println("Category Not Found");
        }

        categoryRepository.delete(category);
    }
}
