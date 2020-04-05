package cn.edu.csu.dyp.Service;

import cn.edu.csu.dyp.Persistence.CartMapper;
import cn.edu.csu.dyp.model.cart.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class CartService {
//    private static Logger logger=Logger.getLogger(DataBaseDao.class);

    @Autowired
    private CartMapper cartMapper;

    private void testNotNull(Integer userId, Integer itemId, Integer delta){
        if(userId==null && itemId == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"UserID and ItemID are required");
        }
        else if(userId==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"UserID are required");
        }
        else if(itemId == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"ItemID are required");
        }

        if(delta==null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"delta are required");
    }

    public void modify(Integer userId,Integer itemId,Integer delta) {
        testNotNull(userId,itemId,delta);
        //购物车中不存在该商品
        if(getNumber(userId, itemId)==null){
            if(delta<=0)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"quantity must be positive");
            else
                addToCart(userId,itemId,delta);
        }
        else{
            int newQuantity=getNumber(userId,itemId)+delta;
            if(newQuantity<=0)
                removeItem(userId,itemId);
            else
                changeNumber(userId,itemId,newQuantity);
        }
    }

    private void addToCart(Integer userId,Integer itemId,Integer quantity) {
        cartMapper.addCart(userId,itemId,quantity);
    }

    private void changeNumber(Integer userId,Integer itemId,Integer newQuantity) {
        cartMapper.updateCartQuantity(userId,itemId,newQuantity);
    }

    private void removeItem(Integer userId,Integer itemId) {
        cartMapper.deleteCartByItemId(userId,itemId);
    }

    private Integer getNumber(Integer userId,Integer itemId) {
        return cartMapper.getQuantityByItemId(userId,itemId);
    }

    public List<CartItem> getCart(Integer userId) {
        return cartMapper.getCartByUserId(userId);
    }

    public void deleteAll(Integer userId){
        cartMapper.deleteCartByUserId(userId);
    }
}
