package com.samsung.bt_spring_boot.service;

import com.samsung.bt_spring_boot.model.entities.products;
import com.samsung.bt_spring_boot.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {
    @Autowired
    ProductRepository productRepository;

    public List<products> getAllProducts() {
        return productRepository.findAll();
    }

    public List<products> searchProductByName(String productName) {
        return productRepository.findByProductNameContaining(productName);
    };
}
