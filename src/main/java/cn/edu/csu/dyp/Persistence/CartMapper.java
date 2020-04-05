package cn.edu.csu.dyp.Persistence;

import cn.edu.csu.dyp.model.cart.CartItem;
import cn.edu.csu.dyp.model.goods.Item;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CartMapper {
    void addCart(@Param("userId")int userId,@Param("itemId")int itemId,@Param("quantity")int quantity);
    void deleteCartByItemId(@Param("userId")int userId,@Param("itemId")int itemId);
    void deleteCartByUserId(int userId);
    void updateCartQuantity(@Param("userId")int userId,@Param("itemId")int itemId,@Param("quantity")int quantity);
    List<CartItem> getCartByUserId(int userId);
    Integer getQuantityByItemId(@Param("userId")int userId,@Param("itemId")int itemId);
}
