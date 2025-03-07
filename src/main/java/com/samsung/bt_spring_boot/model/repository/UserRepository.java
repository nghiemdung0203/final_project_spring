package com.samsung.bt_spring_boot.model.repository;

import com.samsung.bt_spring_boot.model.entities.person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<person, String> {
    person findByUsername(String username);

}
