package com.yetgim.ecommerce.controller;

import com.yetgim.ecommerce.dto.carts.CartItemAddRequestDto;
import com.yetgim.ecommerce.dto.carts.CartItemResponseDto;
import com.yetgim.ecommerce.service.abstracts.CartItemService;
import com.yetgim.ecommerce.service.abstracts.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {

   private final CartItemService cartItemService;

@PostMapping("/create")
   public ResponseEntity<String> AddToCart(@RequestBody CartItemAddRequestDto dto){
       cartItemService.AddCart(dto);
       return ResponseEntity.status(HttpStatus.OK).body("Sepete eklendi.");

   }


   @GetMapping("/getitems")
    public ResponseEntity<List<CartItemResponseDto>> getItems(){

    List<CartItemResponseDto> dtos = cartItemService.getAllCartByCurrentUser();
    return ResponseEntity.ok(dtos);

   }

}
