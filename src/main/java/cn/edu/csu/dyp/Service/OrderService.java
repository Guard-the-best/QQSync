package cn.edu.csu.dyp.Service;

import cn.edu.csu.dyp.Persistence.OrderMapper;
import cn.edu.csu.dyp.model.cart.CartItem;
import cn.edu.csu.dyp.model.order.Order;
import cn.edu.csu.dyp.model.order.OrderItem;
import cn.edu.csu.dyp.model.cart.Cart;
import cn.edu.csu.dyp.model.util.OrderStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Transactional(propagation = Propagation.REQUIRED)
    public Order makeOrder(Integer userId, String shipAddress, String billAddress, Cart cart) {
        if (cart.getItems().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "empty order is not allowed");
        }
        Order order = new Order();
        order.setUserId(userId);
        order.setOrderDate(new Date());
        order.setShipAddress(shipAddress);
        order.setBillAddress(billAddress);
        order.setStatus(OrderStat.success); // 这里查看了一下过去的代码，似乎dao层原本会填入一个-1，而不是一个orderStat，因此这里先默认为success。
        orderMapper.addOrder(order);

        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem it : cart.getItems()) {
            OrderItem temp = new OrderItem();
            temp.setItemId(it.getItemId());
            temp.setListPrice(it.getListPrice());
            temp.setAttributes(it.getAttributes());
            temp.setNumber(it.getQuantity());
            temp.setOrderId(order.getOrderId());//?
            orderItems.add(temp);
        }
        orderMapper.addOrderItem(orderItems);
        order.setItems(orderItems);
        return order;
    }
//
    public List<Order> getOrderByUser(Integer userId) {
        if (userId == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "userId is required for querying orders");
        List<Order> orders = orderMapper.getOrder(userId);
        for (Order it : orders) {
            it.setItems(orderMapper.getOrderItems(it.getOrderId()));
        }
        return orders;
    }
}
