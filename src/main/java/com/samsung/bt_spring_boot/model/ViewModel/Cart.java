package com.samsung.bt_spring_boot.model.ViewModel;

import com.samsung.bt_spring_boot.model.entities.Products;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Cart {
    private Map<Long, CartItem> items = new HashMap<>();

    public void addItem(Products product, int quantity) {
        if (items.containsKey(product.getId())) {
            CartItem existingItem = items.get(product.getId());
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            items.put(Long.valueOf(product.getId()), new CartItem(product, quantity));
        }
    }

    public Map<Long, CartItem> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0.0;
        for (CartItem item : items.values()) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }
    // Xóa sản phẩm khỏi giỏ hàng
    public void removeFromCart(Long productId) {
        items.remove(productId);
    }
}
