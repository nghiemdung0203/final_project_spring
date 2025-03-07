package com.samsung.bt_spring_boot.controller;

import com.samsung.bt_spring_boot.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @GetMapping("/login")
    public String login() {
        return "Login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               HttpSession session,
                               Model model) {

        if (userService.validateUser(username, password)) {
            session.setAttribute("username", username);
            return "redirect:/home";
        } else {
            System.out.println("Invalid username or password");
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu!");
            return "Login";
        }
    }
}
