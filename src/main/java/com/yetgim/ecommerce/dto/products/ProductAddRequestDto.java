package com.yetgim.ecommerce.dto.products;

import com.yetgim.ecommerce.aop.annotations.ProductNameMustBeUnique;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record ProductAddRequestDto(

        @NotEmpty(message = "İsim alanı boş olamaz.")
        @Length(min = 2, message = "İsim alanı minimum 2 haneli olmalıdır.")
        @ProductNameMustBeUnique
        String name,


        @Positive( message = "Ürün fiyat alanı negatif değer alamaz.")
        double price,

        @Positive( message = "Ürün stok alanı negatif değer alamaz.")
        int stock,

        Integer categoryId){
}
