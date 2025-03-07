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
    private String id;
    @Column(name="Product name", nullable = false)
    private String productName;

    @Column(name="Quantity")
    private Integer quantity = 0;

    @Column(name = "Price", nullable = false)
    private Long price;

    @Column(name = "Avatar")
    private String ava;

    @PrePersist  // Sinh ID trước khi insert
    public void generateId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
