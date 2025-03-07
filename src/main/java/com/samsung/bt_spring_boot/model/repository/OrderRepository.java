package com.samsung.bt_spring_boot.model.repository;

import com.samsung.bt_spring_boot.model.entities.Order;
import com.samsung.bt_spring_boot.model.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(Users user);
}

