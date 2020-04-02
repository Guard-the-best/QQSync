package cn.edu.csu.dyp.Persistence;

import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.order.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartMapper {
    void addItem(int parentId,int itemId);
    Cart getCart(int userId);
}
