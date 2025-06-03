package com.yetgim.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private  Integer id;

    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private double price;
    @Column
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems;

}
