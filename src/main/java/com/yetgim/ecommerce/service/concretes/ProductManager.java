package com.yetgim.ecommerce.service.concretes;

import com.yetgim.ecommerce.dto.products.ProductAddRequestDto;
import com.yetgim.ecommerce.dto.products.ProductResponseDto;
import com.yetgim.ecommerce.dto.products.ProductUpdateRequestDto;
import com.yetgim.ecommerce.entities.Product;
import com.yetgim.ecommerce.exceptions.types.BusinessException;
import com.yetgim.ecommerce.exceptions.types.NotFoundException;
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
        nameMustBeUnique(dto.name());
        Product product = mapper.convertToEntity(dto);
        productRepository.save(product);
    }

    @Override
    public void update(ProductUpdateRequestDto dto) {

    /*    Product product = productRepository.findById(dto.id())
                .orElseThrow(()-> new NotFoundException("İlgili Ürün bulunamadı."));*/

        boolean isPresent = productRepository.existsById(dto.id());
        if (!isPresent){
            throw new NotFoundException("İlgili Ürün bulunamadı.");
        }

        Product updatedProduct = mapper.convertToEntity(dto);

        productRepository.save(updatedProduct);

    }

    @Override
    public List<ProductResponseDto> getAll() {
        List<Product> products = this.productRepository.findAll();
        List<ProductResponseDto> dtos = this.mapper.convertToResponseList(products);
        return  dtos;
    }

    @Override
    public ProductResponseDto getById(int id) {
               Product product = productRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("İlgili Ürün bulunamadı."));

               return  mapper.convertToResponse(product);
    }

    @Override
    public void delete(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("İlgili Ürün bulunamadı."));

        this.productRepository.delete(product);
    }

    @Override
    public List<Product> getAllData() {
        return this.productRepository.findAll();
    }

    @Override
    public List<ProductResponseDto> getAllByNameContains(String name) {

        List<Product> products = this.productRepository.findAllByNameContains(name);
        return mapper.convertToResponseList(products);
    }

    @Override
    public List<ProductResponseDto> getAllByPriceRange(double min, double max) {
        List<Product> products = this.productRepository.findAllByPriceBetween(min,max);
        return mapper.convertToResponseList(products);
    }

    @Override
    public List<ProductResponseDto> getAllByStockRange(int min, int max) {
        List<Product> products = this.productRepository.findAllByStockBetween(min,max);
        return mapper.convertToResponseList(products);
    }

    @Override
    public List<ProductResponseDto> getAllByCategoryIdAndPriceRange(int categoryId, double min, double max) {
        List<Product> products = this.productRepository.findAllByCategory_IdAndPriceBetween(categoryId,min,max);
        return mapper.convertToResponseList(products);
    }

    @Override
    public List<ProductResponseDto> getAllByCategoryName(String name) {
        List<Product> products = this.productRepository.getAllByCategory_Name(name);
        return mapper.convertToResponseList(products);
    }

    private  void  nameMustBeUnique(String name){
        boolean isPresent = this.productRepository.existsByName(name);
        if (isPresent){
            throw new BusinessException("Ürün ismi benzersiz olmalıdır."+ name+" isminde bir ürün mevcuttur.");
        }
    }
}
