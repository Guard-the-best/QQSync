package cn.edu.csu.dyp.service;

import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.user.LineItem;
import cn.edu.csu.dyp.model.user.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceTest {

//    @Test
    public void makeOrder() {
        List<LineItem> list = new ArrayList<>();
        list.add(new LineItem(new Item("10001",null,null,null,null),1));
        new OrderService().makeOrder("1","home","work",list);
    }

//    @Test
    public void getOrderByUser() {
        List<Order> list = new OrderService().getOrderByUser("1");
        for(Order order:list)
            System.out.println(order);
    }
}