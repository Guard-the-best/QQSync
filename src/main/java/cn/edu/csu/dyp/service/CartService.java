package cn.edu.csu.dyp.service;

import cn.edu.csu.dyp.model.user.LineItem;

import java.util.List;

public class CartService {
    /*
    * Output:是否成功，删除过多（不能删不存在的）会成功，添加超库存会失败
    * */
    public boolean modifyCart(String userId,String itemId,int delta) {
        return false;
    }

    /*
    * 不方便的操作可以每次修改都调用一次？
    * 在购物车页面进行物品数量删减可以不调用？
    * */
    public List<LineItem> getCart(String userId) {
        return null;
    }
}
