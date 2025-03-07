package com.samsung.bt_spring_boot.service;

import com.samsung.bt_spring_boot.common.SecurityConfig;
import com.samsung.bt_spring_boot.model.entities.Users;
import com.samsung.bt_spring_boot.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public void save(Users user) {
        userRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ADMIN"))
        );
    }
    @Autowired
    SecurityConfig securityConfig;
    public boolean validateUser(String username, String password) {
        Users user = userRepository.findByUsername(username);
        return user != null && securityConfig.getPasswordEncoder().matches(password, user.getPassword());
    }
}

