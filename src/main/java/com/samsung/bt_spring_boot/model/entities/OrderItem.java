package com.samsung.bt_spring_boot.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) // Chỉ rõ khóa ngoại
    private products product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false) // Chỉ rõ khóa ngoại
    private Order order; // OrderItem cần tham chiếu tới Order

    private int quantity;
}

