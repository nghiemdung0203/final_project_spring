package com.samsung.bt_spring_boot.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class person {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="User name", nullable = false)
    private String username;

    @Column(name="Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;
}
