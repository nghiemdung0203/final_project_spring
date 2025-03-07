package com.samsung.bt_spring_boot.model.repository;

import com.samsung.bt_spring_boot.model.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Products, String> {
    List<Products> findByProductNameContainingIgnoreCase(String keyword);
}

