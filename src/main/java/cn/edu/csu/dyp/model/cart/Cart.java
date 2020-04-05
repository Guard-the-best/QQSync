package cn.edu.csu.dyp.model.cart;

import lombok.Data;

import java.util.List;

@Data
//最终还是加上了，我发现总要get的
public class Cart {
    private List<CartItem> items;
}


