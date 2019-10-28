package cn.edu.csu.dyp.service;

import java.util.List;


import cn.edu.csu.dyp.model.user.LineItem;
import cn.edu.csu.dyp.model.user.Order;

public class OrderService {
    /*
     * Date sql自动填写,lineItem only use itemId and quantity
     * */
    public boolean makeOrder(String userId, String shipAddress, String billAddress, List<LineItem> lineItems) {
        return false;
    }

    public List<Order> getOrderByUser(String userId) {
        return null;

    }
}
