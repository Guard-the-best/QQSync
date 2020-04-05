package cn.edu.csu.dyp.Persistence;


import cn.edu.csu.dyp.model.order.Order;
import cn.edu.csu.dyp.model.order.OrderItem;
import cn.edu.csu.dyp.model.util.OrderStat;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@MapperScan("cn.edu.csu.dyp.Persistence")
public class OrderDaoTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    void insertOrderTest(){
        Order order = new Order();
        System.out.println(order.getOrderId());
        order.setUserId("1");
        order.setShipAddress("Beijing");
        order.setBillAddress("Shanghai");
        orderMapper.addOrder(order);
        System.out.println(order.getOrderId());
    }

    @Test
    void getOrderTest(){
        String userId = "1";
        List<Order> list = orderMapper.getOrder(userId);
        System.out.println(list.get(0).getBillAddress());
    }

    @Test
    void updateOrderTest(){
        Date date = new Date();
        OrderStat orderStat = OrderStat.success;
        Order order = new Order();
        order.setBillAddress("dada");
        order.setShipAddress("ship");
        order.setUserId("1");
        order.setOrderDate(date);
        order.setOrderId("2");
        order.setStatus(orderStat);
        orderMapper.updateOrder(order);
    }

    @Test
    void addOrderItemTest() {
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("2", 1, new BigDecimal("10.00"), "badboi", 10));
        orderItems.add(new OrderItem("2", 1, new BigDecimal("10.00"), "goodaboi", 120));
        orderMapper.addOrderItem(orderItems);
    }

    @Test
    void getOrderItemsTest() {
        List<OrderItem> orderItems = orderMapper.getOrderItems("2");
        System.out.println(orderItems.size());
    }
}
