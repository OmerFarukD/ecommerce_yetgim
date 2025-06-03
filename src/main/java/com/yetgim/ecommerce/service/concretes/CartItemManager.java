package com.yetgim.ecommerce.service.concretes;

import com.yetgim.ecommerce.dto.carts.CartItemAddRequestDto;
import com.yetgim.ecommerce.dto.carts.CartItemResponseDto;
import com.yetgim.ecommerce.entities.Cart;
import com.yetgim.ecommerce.entities.CartItem;
import com.yetgim.ecommerce.repository.CartItemRepository;
import com.yetgim.ecommerce.service.abstracts.CartItemService;
import com.yetgim.ecommerce.service.abstracts.CartService;
import com.yetgim.ecommerce.utils.AuthenticationHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemManager implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartService cartService;


    // todo: Sepet oluşturma işlemi eklenecek
    @Override
    public void AddCart(CartItemAddRequestDto dto) {
        Long userId = AuthenticationHelper.getUserId();
        Long getCartId = cartService.getCartId(userId);

        Cart cart = this.cartService.getCart(userId);

        if (getCartId == 0L){
            cartService.createCart(userId);
        }

        CartItem cartItem = CartItemAddRequestDto.convertToEntity(dto);
        cartItem.setCart(cart);
        this.cartItemRepository.save(cartItem);
    }

    @Override
    public void DeleteCartItem(Long id) {
         this.cartItemRepository.deleteById(id);
    }

    @Override
    public List<CartItemResponseDto> getAllCartByCurrentUser() {

        Long userId = AuthenticationHelper.getUserId();
        Cart cart = this.cartService.getCart(userId);
        List<CartItem> cartItems = cart.getCartItems();
        List<CartItemResponseDto> responses =cartItems.stream().map(CartItemResponseDto::covertToResponseDto).toList();
        return responses;
    }
}
