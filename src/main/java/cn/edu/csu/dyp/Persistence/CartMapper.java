package cn.edu.csu.dyp.Persistence;

import cn.edu.csu.dyp.model.goods.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface CartMapper {
    void addCart(int userId,int itemId,int quantity);
    void deleteCartByItemId(int itemId);
    void getCartByUserId(int UserId);
    void updateCartQuantity(int userId,int itemId,int quantity);
    int getCartNumber(int userId,int itemId);
}
