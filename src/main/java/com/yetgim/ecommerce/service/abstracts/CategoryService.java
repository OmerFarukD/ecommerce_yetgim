package com.yetgim.ecommerce.service.abstracts;

import com.yetgim.ecommerce.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(int id);
    void  add(Category category);
    void update(Category category);
    void delete(int id);

}
