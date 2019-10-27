package cn.edu.csu.dyp.service;

import java.util.List;

import cn.edu.csu.dyp.dao.orderDao.GetCartDao;
import cn.edu.csu.dyp.dao.orderDao.MakeOrderDao;
import cn.edu.csu.dyp.dao.orderDao.UpdateLineItemDao;
import cn.edu.csu.dyp.dao.util.DataBaseDao;
import cn.edu.csu.dyp.model.user.LineItem;
import cn.edu.csu.dyp.model.user.Order;

public class OrderService {
    public void makeOrder(Order order) {
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            dataBaseDao.query(new MakeOrderDao(order));
            for(String lineItemId:order.getLineItemIds()) {
                dataBaseDao.query(new UpdateLineItemDao(lineItemId,order.getOrderId()));
            }
        }
    }

    Order getOrder(String orderId) {
        return null;

    }

    List<Order> getOrderByUser(String userId) {
        return null;

    }

    List<LineItem> getCart(String userId) {
        List<LineItem> res = null;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            res = dataBaseDao.query(new GetCartDao(userId));
        }
        return res;
    }

}
