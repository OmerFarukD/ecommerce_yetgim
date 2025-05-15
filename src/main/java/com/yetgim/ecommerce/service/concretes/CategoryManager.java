package com.yetgim.ecommerce.service.concretes;

import com.yetgim.ecommerce.dto.categories.CategoryAddRequestDto;
import com.yetgim.ecommerce.dto.categories.CategoryResponseDto;
import com.yetgim.ecommerce.dto.categories.CategoryUpdateRequestDto;
import com.yetgim.ecommerce.entities.Category;
import com.yetgim.ecommerce.exceptions.types.BusinessException;
import com.yetgim.ecommerce.exceptions.types.NotFoundException;
import com.yetgim.ecommerce.exceptions.types.ValidationException;
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
            throw  new NotFoundException("İlgili id değerine göre bir kategori bulunamamıştır.");
        }

        CategoryResponseDto response = new CategoryResponseDto(category.get().getId(), category.get().getName());
        return response;
    }

    @Override
    public void add(CategoryAddRequestDto dto) {


        if (dto.name().length()<2){
            throw new ValidationException("İsim alanı minimum 2 haneli olmalıdır.");
        }

           Optional<Category> category = categoryRepository.getByCategoryName(dto.name());

           if (category.isPresent()){
               throw new BusinessException("Eklemek istediğiniz kategori benzersiz olmalıdır.");
           }

        Category newCategory = new Category();
        newCategory.setName(dto.name());
        this.categoryRepository.save(newCategory);
    }

    @Override
    public void update(CategoryUpdateRequestDto dto) {

        Category category = categoryRepository.findById(dto.id())
                .orElseThrow(()-> new NotFoundException("İlgili Kategori bulunamadı."));


        if (category.getName().equals(dto.name())){
            throw new BusinessException("Kategori adı hiç değişmedi.");
        }

        category.setId(dto.id());
        category.setName(dto.name());
        categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("İlgili Kategori Bulunamadı."));
        categoryRepository.delete(category);
    }
}
