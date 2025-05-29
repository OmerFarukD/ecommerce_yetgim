package com.yetgim.ecommerce.aop.annotations;

import com.yetgim.ecommerce.aop.manager.ProductNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

    @Constraint(
            validatedBy = {ProductNameValidator.class}
    )
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ProductNameMustBeUnique {
        String message() default "Ürün adı benzersiz olmalıdır.";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

    }


