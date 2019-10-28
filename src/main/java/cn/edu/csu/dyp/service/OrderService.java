package cn.edu.csu.dyp.service;

import java.util.List;

import cn.edu.csu.dyp.dao.orderDao.GetCartDao;
import cn.edu.csu.dyp.dao.orderDao.MakeOrderDao;
import cn.edu.csu.dyp.dao.orderDao.UpdateLineItemDao;
import cn.edu.csu.dyp.dao.util.DataBaseDao;
import cn.edu.csu.dyp.model.user.Address;
import cn.edu.csu.dyp.model.user.LineItem;
import cn.edu.csu.dyp.model.user.Order;

public class OrderService {
    /*
     * Date sql自动填写
     * */
    public boolean makeOrder(String userId, Address shipAddress, Address billAddress, List<LineItem> lineItems) {
        return false;
    }

    public List<Order> getOrderByUser(String userId) {
        return null;

    }
}
