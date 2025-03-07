package com.samsung.bt_spring_boot.service;

import com.samsung.bt_spring_boot.model.entities.person;
import com.samsung.bt_spring_boot.model.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class personService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public personService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public person findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
