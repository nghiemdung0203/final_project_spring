package com.samsung.bt_spring_boot.model.ViewModel;

import com.samsung.bt_spring_boot.model.entities.products;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItem {
    private products product;
    private int quantity;

}
