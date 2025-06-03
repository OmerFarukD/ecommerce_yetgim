package com.yetgim.ecommerce.service.concretes;

import com.yetgim.ecommerce.entities.Cart;
import com.yetgim.ecommerce.entities.User;
import com.yetgim.ecommerce.exceptions.types.BusinessException;
import com.yetgim.ecommerce.exceptions.types.NotFoundException;
import com.yetgim.ecommerce.repository.CartRepository;
import com.yetgim.ecommerce.repository.UserRepository;
import com.yetgim.ecommerce.service.abstracts.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartManager implements CartService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;


    @Override
    public void createCart(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new NotFoundException("Kullanıcı Bulunamadı"));

        boolean exist = cartRepository.existsByUser_Id(userId);
        if (exist){
            throw new BusinessException("Kullanıcının zaten bir sepeti var.");
        }

        Cart cart = new Cart();
        cart.setUser(user);

        cartRepository.save(cart);
    }

    @Override
    public Long getCartId(Long userId) {
        Cart nullCart = new Cart();
        nullCart.setId(0L);

        Optional<Cart> cart = this.cartRepository.findByUser_Id(userId);
        if (cart.isEmpty()){
            return nullCart.getId();
        }
        return cart.get().getId();

    }


    @Override
    public Cart getCart(Long userId) {
        Cart nullCart = new Cart();
        nullCart.setId(0L);
        nullCart.setUser(new User());

        Optional<Cart> cart = this.cartRepository.findByUser_Id(userId);
        return cart.orElse(nullCart);

    }
}
