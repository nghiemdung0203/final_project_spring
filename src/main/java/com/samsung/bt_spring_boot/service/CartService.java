package com.samsung.bt_spring_boot.service;

import com.samsung.bt_spring_boot.model.ViewModel.Cart;
import com.samsung.bt_spring_boot.model.entities.Products;
import com.samsung.bt_spring_boot.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

@Service
public class CartService {
    @Autowired
    ProductRepository productRepository;

    public Cart getCart(WebRequest request) {
        Cart cart = (Cart) request.getAttribute("cart", WebRequest.SCOPE_SESSION);
        if (cart == null) {
            cart = new Cart();
            request.setAttribute("cart", cart, WebRequest.SCOPE_SESSION);
        }
        return cart;
    }

    public void addToCart(WebRequest request, Long productId, int quantity) {
        Cart cart = getCart(request);
        Products product = productRepository.findById(String.valueOf(productId)).orElseThrow(() -> new RuntimeException("Product not found"));
        cart.addItem(product, quantity);
    }

    public void removeFromCart(WebRequest request, Long productId) {
        Cart cart = getCart(request);
        cart.removeFromCart(productId);
    }

    public double getTotal(WebRequest request) {
        Cart cart = getCart(request);
        return cart.getTotal();
    }
}
