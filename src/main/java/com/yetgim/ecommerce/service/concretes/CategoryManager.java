package com.yetgim.ecommerce.service.concretes;

import com.yetgim.ecommerce.entities.Category;
import com.yetgim.ecommerce.repository.CategoryRepository;
import com.yetgim.ecommerce.service.abstracts.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CategoryManager  implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        Category category = categoryRepository.findById(id).get();

        return category;
    }

    @Override
    public void add(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }
}
