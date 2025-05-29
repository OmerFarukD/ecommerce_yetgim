package com.yetgim.ecommerce.aop.tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "performances")
@Getter
@Setter
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String methodName;

    @Column
    private double durationSeconds;

    @Column
    private LocalDateTime executedAt;
}
