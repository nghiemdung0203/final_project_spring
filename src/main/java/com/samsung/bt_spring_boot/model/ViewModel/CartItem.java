package com.samsung.bt_spring_boot.model.ViewModel;

import com.samsung.bt_spring_boot.model.entities.Products;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItem {
    private Products product;
    private int quantity;

}
