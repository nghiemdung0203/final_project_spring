package com.samsung.bt_spring_boot.controller;

import com.samsung.bt_spring_boot.model.entities.person;
import com.samsung.bt_spring_boot.model.entities.products;
import com.samsung.bt_spring_boot.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class homeController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/home")
    public String getProducts(Model model) {
        List<products> productsList = productRepository.findAll();
        model.addAttribute("products", productsList);
        return "HomePage";
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam(defaultValue = "") String productName) {
        List<products>result =productRepository.findByProductNameContaining(productName);
        return ResponseEntity.ok(result);
    };

    @PostMapping("/savePerson")
    public String savePerson() {
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(defaultValue = "") String error) {
        person user = new person();
        model.addAttribute("user", user);
        model.addAttribute("error", error);

        return "Login";
    }


}
