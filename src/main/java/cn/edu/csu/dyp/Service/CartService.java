package cn.edu.csu.dyp.Service;

import cn.edu.csu.dyp.Persistence.CartMapper;
import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.user.LineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
//    private static Logger logger=Logger.getLogger(DataBaseDao.class);

    @Autowired
    private CartMapper cartMapper;

    public Boolean addToCart(String userId,String itemId) {
//        if(userId==null || itemId == null){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"UserID and ItemID are required");
//        }
//
//        List<LineItem> lineItems = new ArrayList<>();


        return null;
    }

    public Boolean changeNumber(String userId,String itemId,int newQuantity) {
        return null;
    }

    public Boolean removeItem(String userId,String itemId) {
        return null;
    }

    public Integer getNumber(String userId) {
        return null;
    }

    /*
    * 不方便的操作可以每次修改都调用一次？
    * 在购物车页面进行物品数量删减可以不调用？
    * */
//    public List<LineItem> getCart(String userId) {
//        return null;
//    }
}
