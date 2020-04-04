package cn.edu.csu.dyp.Service;

import cn.edu.csu.dyp.Persistence.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CartService {
//    private static Logger logger=Logger.getLogger(DataBaseDao.class);

    @Autowired
    private CartMapper cartMapper;

    public boolean isUserIdAndItemIdNULL(String userId,String itemId){
        boolean isNULL = true;
        if(userId==null && itemId == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"UserID and ItemID are required");
        }
        else if(userId==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"UserID are required");
        }
        else if(itemId == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"ItemID are required");
        }
        else {
            isNULL=false;
        }
        return isNULL;
    }

    public void addToCart(String userId,String itemId,int quantity) {
        if(!isUserIdAndItemIdNULL(userId,itemId)){
            int intUserId = Integer.parseInt(userId);
            int intItemId =  Integer.parseInt(itemId);
            cartMapper.addCart(intUserId,intItemId,quantity);
        }
    }

    public void changeNumber(String userId,String itemId,int newQuantity) {
        if(!isUserIdAndItemIdNULL(userId,itemId)){
            int intUserId = Integer.parseInt(userId);
            int intItemId =  Integer.parseInt(itemId);
            cartMapper.updateCartQuantity(intUserId,intItemId,newQuantity);
        }
    }

    public void removeItem(String userId,String itemId) {
        if(!isUserIdAndItemIdNULL(userId,itemId)){
            int intItemId =  Integer.parseInt(itemId);
            cartMapper.deleteCartByItemId(intItemId);
        }
    }

    public Integer getNumber(String userId,String itemId) {
        int numOfCartItem=0;
        if(!isUserIdAndItemIdNULL(userId,itemId)){
            int intUserId = Integer.parseInt(userId);
            int intItemId =  Integer.parseInt(itemId);
            cartMapper.getCartNumber(intUserId,intItemId);
        }
        return numOfCartItem;
    }


    /*
    * 不方便的操作可以每次修改都调用一次？
    * 在购物车页面进行物品数量删减可以不调用？
    * */
//    public List<LineItem> getCart(String userId) {
//        return null;
//    }
}
