package cn.edu.csu.dyp.model.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//最终还是加上了，我发现总要get的
public class Cart {
    private List<CartItem> items;
}


