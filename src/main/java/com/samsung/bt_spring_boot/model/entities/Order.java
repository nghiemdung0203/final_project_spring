package com.samsung.bt_spring_boot.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Chỉ rõ khóa ngoại
    private Users user;

    @OneToMany(mappedBy = "order") // Đảm bảo phía OrderItem được tham chiếu đúng
    private List<OrderItem> orderItems;
}
