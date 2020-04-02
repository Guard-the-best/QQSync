package cn.edu.csu.dyp.Persistence;


import cn.edu.csu.dyp.model.user.Order;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("cn.edu.csu.dyp.Persistence")
public class OrderDaoTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    void insertOrderTest(){
        Order order = new Order();
        order.setUserId("LiHua");
        order.setShipAddress("Beijing");
        order.setBillAddress("Shanghai");
        orderMapper.addOrder(order);
    }

    @Test
    void getOrderTest(){
        String userId = "LiHua";
        List<Order> list = orderMapper.getOrder(userId);
        System.out.println(list.get(0).getBillAddress());
    }

    @Test
    void getOrderIdTest(){
        String userId = "LiHua";
        String orderId = orderMapper.getOrderId(userId);
        System.out.println(orderId);
    }

}
