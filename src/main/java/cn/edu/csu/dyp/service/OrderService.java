package cn.edu.csu.dyp.service;

import java.util.ArrayList;
import java.util.List;


import cn.edu.csu.dyp.dao.goodsDao.GetItemByIdDao;
import cn.edu.csu.dyp.dao.orderDao.AddOrderDao;
import cn.edu.csu.dyp.dao.orderDao.GetOrderDao;
import cn.edu.csu.dyp.dao.orderDao.GetOrderIdDao;
import cn.edu.csu.dyp.dao.orderDao.ModifyItemStatusDao;
import cn.edu.csu.dyp.dao.util.DataBaseDao;
import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.user.LineItem;
import cn.edu.csu.dyp.model.user.Order;

public class OrderService {
    /*
     * Date sql自动填写,lineItem only use itemId and quantity
     * */
    public boolean makeOrder(String userId, String shipAddress, String billAddress, List<LineItem> lineItems) {
        boolean res =false;
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            if(dataBaseDao.query(new AddOrderDao(userId,shipAddress,billAddress))){
                String orderId = dataBaseDao.query(new GetOrderIdDao(userId));
                if (orderId!=null && dataBaseDao.query(new ModifyItemStatusDao(userId,orderId,lineItems)))
                    res =true;
            }
        }
        return res;
    }

    public List<Order> getOrderByUser(String userId) {
        List <Order> orders,res = new ArrayList<>();
        try(DataBaseDao dataBaseDao = new DataBaseDao()) {
            orders=dataBaseDao.query(new GetOrderDao(userId));
            for(Order order:orders) {
                List<LineItem> addLineItemList= new ArrayList<>();
                for(LineItem lineItem:order.getLineItemList()) {
                    Item addItem =  dataBaseDao.query(new GetItemByIdDao(lineItem.getItem().getItemId()));
                    addLineItemList.add(new LineItem(addItem,lineItem.getQuantity()));
                }
                res.add(new Order(order.getOrderId(),order.getUserId(),order.getOrderDate(),order.getShipAddress(),order.getBillAddress(),order.getStatus(),addLineItemList));
            }
        }
        return res;
    }
}
