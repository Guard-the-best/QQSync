package cn.edu.csu.dyp.Service;

import cn.edu.csu.dyp.model.order.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class OrderServiceTest {
    @Autowired OrderService orderService;
    @Autowired GoodsService goodsService;

    @Test
    void addOrder(){
        List list = new ArrayList<>();
        OrderItem item = new OrderItem();
        item.setItemId(10001);
        item.setAttributes("test");
        item.setListPrice(new BigDecimal(100));
        item.setNumber(1);
        list.add(item);
        orderService.makeOrder(1,"jh","jh",list);
        System.out.println(orderService.getOrderByUser(1).get(0));
        System.out.println(goodsService.getItemById(10001));
    }

}
