package cn.edu.csu.dyp.Service;

import cn.edu.csu.dyp.Persistence.OrderMapper;
import cn.edu.csu.dyp.Persistence.UserMapper;
import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.order.Order;
import cn.edu.csu.dyp.model.order.OrderItem;
import cn.edu.csu.dyp.model.user.Address;
import cn.edu.csu.dyp.model.user.Cart;
import cn.edu.csu.dyp.model.util.OrderStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
//    private static Logger logger=Logger.getLogger(DataBaseDao.class);
//    /*
//     * Date sql自动填写,lineItem only use itemId and quantity
//     * */
    private OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public void makeOrder(String userId, String shipAddress, String billAddress, Cart cart) {
        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();
        for (Map.Entry<Item, Integer> it : cart.getItems().entrySet()) {
            OrderItem temp = new OrderItem(it.getKey().getItemId(), it.getKey().getListPrice(), it.getKey().getAttributes(), it.getValue());
            orderItems.add(temp);
        }
        if(orderItems.size() == 0) return;
        order.setUserId(userId);
        order.setShipAddress(shipAddress);
        order.setBillAddress(billAddress);
        order.setStatus(OrderStat.success); // 这里查看了一下过去的代码，似乎dao层原本会填入一个-1，而不是一个orderStat，因此这里先默认为success。
        orderMapper.addOrder(order);
        orderMapper.addOrderItem(orderItems);
    }
//
//    public List<Order> getOrderByUser(String userId) {
//        return null;
//    }
}
