package com.yetgim.ecommerce.service.concretes;

import com.yetgim.ecommerce.dto.products.ProductAddRequestDto;
import com.yetgim.ecommerce.dto.products.ProductResponseDto;
import com.yetgim.ecommerce.dto.products.ProductUpdateRequestDto;
import com.yetgim.ecommerce.entities.Category;
import com.yetgim.ecommerce.entities.Product;
import com.yetgim.ecommerce.repository.ProductRepository;
import com.yetgim.ecommerce.service.abstracts.ProductService;
import com.yetgim.ecommerce.service.mappers.products.ProductMapperBase;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapperBase mapper;

    public ProductManager(ProductRepository productRepository, ProductMapperBase mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public void add(ProductAddRequestDto dto) {
        Product product = mapper.convertToEntity(dto);
        productRepository.save(product);
    }

    @Override
    public void update(ProductUpdateRequestDto dto) {

    }

    @Override
    public List<ProductResponseDto> getAll() {
        return List.of();
    }

    @Override
    public ProductResponseDto getBById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
