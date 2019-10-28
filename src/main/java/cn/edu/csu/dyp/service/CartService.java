package cn.edu.csu.dyp.service;

import cn.edu.csu.dyp.model.user.LineItem;

import java.util.List;

public class CartService {
    /*
    * Output:添加超库存会失败，库存还可以前端判断
    * */
    public boolean addToCart(String userId,String itemId) {
    }

    /*
     * Output:添加超库存会失败，库存还可以前端判断
     * */
    public boolean changeNumber(String userId,String itemId,int newQuantity) {
    }

    public boolean removeItem()(String userId,String itemId) {
    }

    public int getNumber(String userId) {
        return 0;
    }

    /*
    * 不方便的操作可以每次修改都调用一次？
    * 在购物车页面进行物品数量删减可以不调用？
    * */
    public List<LineItem> getCart(String userId) {
        return null;
    }
}
