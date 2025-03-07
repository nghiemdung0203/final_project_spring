package com.samsung.bt_spring_boot.controller;

import com.samsung.bt_spring_boot.model.entities.Products;
import com.samsung.bt_spring_boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class homeController {
    @Autowired
    ProductService productService;

    @GetMapping("/home")
    public String getAllProducts(final Model model, @RequestParam(defaultValue = "") String keyword) throws IOException {
        List<Products> lstProducts = productService.getAllProducts();
        if(keyword!="")
        {
            lstProducts = lstProducts.stream().filter((s)->(s.getProductName()).contains(keyword)).collect(Collectors.toList())
                    .stream().toList();
        }
        model.addAttribute("keyword", keyword);
        model.addAttribute("products", lstProducts);

        return "HomePage";
    }


}
