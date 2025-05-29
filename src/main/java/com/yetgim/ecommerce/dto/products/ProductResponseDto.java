package com.yetgim.ecommerce.dto.products;

import java.io.Serializable;

public record ProductResponseDto(Integer id, String name, double price, int stock, String categoryName) implements Serializable {
}
