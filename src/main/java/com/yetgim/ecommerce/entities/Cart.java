package com.yetgim.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;


    @OneToOne
    @JoinColumn(name = "user_id")
    private  User user;


    @Column
    private double totalPrice;


    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;
}
