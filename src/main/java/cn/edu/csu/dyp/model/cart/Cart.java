package cn.edu.csu.dyp.model.cart;

import cn.edu.csu.dyp.model.goods.Item;
import lombok.Data;

import java.util.List;

@Data
@Deprecated
//最终还是加上了，我发现总要get的
public class Cart {
    private List<CartItem> items;
}


