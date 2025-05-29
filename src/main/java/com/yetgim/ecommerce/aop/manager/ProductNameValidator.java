package com.yetgim.ecommerce.aop.manager;

import com.yetgim.ecommerce.aop.annotations.ProductNameMustBeUnique;
import com.yetgim.ecommerce.dto.products.ProductResponseDto;
import com.yetgim.ecommerce.repository.ProductRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ProductNameValidator implements ConstraintValidator<ProductNameMustBeUnique,String> {

    private final ProductRepository productRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isExist = productRepository.existsByName(s);
        return !isExist;
    }
}
