package com.samsung.bt_spring_boot.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Product name", nullable = false)
    private String productName;

    @Column(name="Quantity")
    private Integer quantity = 0;

    @Column(name = "Price", nullable = false)
    private Long price;

    @Column(name = "Avatar")
    private String ava;
}
