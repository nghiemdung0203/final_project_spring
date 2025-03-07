package com.samsung.bt_spring_boot.controller;

import com.samsung.bt_spring_boot.model.ViewModel.Cart;
import com.samsung.bt_spring_boot.model.entities.Products;
import com.samsung.bt_spring_boot.service.CartService;
import com.samsung.bt_spring_boot.service.ProductService;
import com.samsung.bt_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class homeController {
    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    @GetMapping("/home")
    public String home(final Model model, @RequestParam(defaultValue = "") String keyword, WebRequest request) throws IOException {

        Cart cart = cartService.getCart(request);

        List<Products> lstProducts = productService.getAllProducts();


        boolean hasItemsInCart = !cart.getItems().isEmpty();

        model.addAttribute("cart", cart);
        model.addAttribute("hasItemsInCart", hasItemsInCart);

        model.addAttribute("products", lstProducts);

        return "HomePage";
    }


    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String keyword, Model model)
    {
        List<Products> lstProducts = productService.getAllProducts();
        if(keyword!="")
        {
            lstProducts = lstProducts.stream().filter((s)->(s.getProductName()).contains(keyword)).collect(Collectors.toList())
                    .stream().toList();
        }
        model.addAttribute("keyword", keyword);
        return "HomePage";
    }

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam Long productId, @RequestParam(defaultValue = "1") int quantity, WebRequest request, Model model) {
        cartService.addToCart(request, productId, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(WebRequest request, Model model) {
        Cart cart = cartService.getCart(request);
        double total = cartService.getTotal(request);
        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        return "Cart";
    }

    @PostMapping("/removeFromCart")
    public String removeFromCart(@RequestParam("productId") Long productId, WebRequest request) {
        cartService.removeFromCart(request, productId);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(WebRequest request, Model model) {
        return "redirect:/cart";
    }

}
