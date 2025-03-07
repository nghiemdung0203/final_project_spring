package com.samsung.bt_spring_boot.model.repository;

import com.samsung.bt_spring_boot.model.entities.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<products, String> {
    List<products> findByProductNameContaining(String productName);
}
