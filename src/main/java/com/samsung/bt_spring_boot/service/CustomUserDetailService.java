package com.samsung.bt_spring_boot.service;

import com.samsung.bt_spring_boot.model.entities.person;
import com.samsung.bt_spring_boot.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailService {
    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        person user = userRepository.findByUsername(username);

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), encoder.encode(user.getPassword()), Collections.singletonList(new SimpleGrantedAuthority("ADMIN"))
        );
    }
}
