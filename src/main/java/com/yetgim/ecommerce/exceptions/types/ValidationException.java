package com.yetgim.ecommerce.exceptions.types;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
