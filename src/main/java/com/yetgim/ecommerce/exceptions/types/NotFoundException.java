package com.yetgim.ecommerce.exceptions.types;

public class NotFoundException extends  RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
