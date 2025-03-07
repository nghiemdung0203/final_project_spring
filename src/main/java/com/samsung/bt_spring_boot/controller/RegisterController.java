package com.samsung.bt_spring_boot.controller;

import com.samsung.bt_spring_boot.common.SecurityConfig;
import com.samsung.bt_spring_boot.model.entities.Users;
import com.samsung.bt_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    private PasswordEncoder getPasswordEncoder;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "Register"; // Trả về trang đăng ký
    }
    @Autowired
    UserService userService;
    @Autowired
    SecurityConfig securityConfig;
    @PostMapping("/register")
    public String processRegister(@RequestParam String username, @RequestParam String password, Model model) {
        try {

            userService.loadUserByUsername(username);
            model.addAttribute("error", "Tên đăng nhập đã tồn tại!");
            return "register";
        } catch (UsernameNotFoundException e) {

            Users newUser = new Users();
            newUser.setUsername(username);
            newUser.setPassword(securityConfig.getPasswordEncoder().encode(password));
            newUser.setRole("User");// Mã hóa mật khẩu trước khi lưu
            userService.save(newUser);

            model.addAttribute("message", "Đăng ký thành công! Vui lòng đăng nhập.");
            return "redirect:/login";
        }
    }
}
