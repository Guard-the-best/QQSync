package cn.edu.csu.dyp.Persistence;


import cn.edu.csu.dyp.model.order.Order;
import cn.edu.csu.dyp.model.order.OrderItem;
import cn.edu.csu.dyp.model.util.OrderStat;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Transactional
@MapperScan("cn.edu.csu.dyp.Persistence")
public class OrderDaoTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    void insertOrderTest(){
        Order order = new Order();
        order.setUserId(1);
        order.setShipAddress("Beijing");
        order.setBillAddress("Shanghai");
        order.setOrderDate(new Date());
        order.setStatus(OrderStat.ordering);
        orderMapper.addOrder(order);
        System.out.println(order.getOrderId());
    }

    @Test
    void getOrderByStatus(){
        Order order = orderMapper.getOrderByStatus(1,OrderStat.ordering);
        System.out.println(order);
    }

    @Test
    void getOrderTest(){
        int userId = 1;
        List<Order> list = orderMapper.getOrder(userId);
        System.out.println(list.get(0));
    }

    @Test
    void updateOrderTest(){
        Date date = new Date();
        OrderStat orderStat = OrderStat.success;
        Order order = orderMapper.getOrderByStatus(1,OrderStat.ordering);
        order.setBillAddress("dada");
        order.setShipAddress("ship");
        order.setUserId(1);
        order.setOrderDate(date);
        order.setStatus(orderStat);
        orderMapper.updateOrder(order);
    }

    @Test
    void addOrderItemTest() {
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem(2, 1, new BigDecimal("10.00"), "badboi", 10));
        orderItems.add(new OrderItem(2, 1, new BigDecimal("10.00"), "goodaboi", 120));
        orderMapper.addOrderItem(orderItems);
    }

    @Test
    void getOrderItemsTest() {
        List<OrderItem> orderItems = orderMapper.getOrderItems(1);
        System.out.println(orderItems.size());
    }
}
