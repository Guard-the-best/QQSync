package cn.edu.csu.dyp.Service;

import org.springframework.stereotype.Service;

@Service
public class CartService {
//    private static Logger logger=Logger.getLogger(DataBaseDao.class);
    public Boolean addToCart(String userId,String itemId) {
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
