package cn.edu.csu.dyp.Service;

import cn.edu.csu.dyp.Persistence.OrderMapper;
import cn.edu.csu.dyp.Util.BaseResponse;
import cn.edu.csu.dyp.model.cart.CartDto;
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
    public Order makeOrder(Integer userId, String shipAddress, String billAddress, List<OrderItem> cart) {
        if (cart==null || cart.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "empty order is not allowed");
        }
        else if(shipAddress==null || billAddress == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"please fill the address first");
        }
        if(haveOrderingOrder(userId))
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"server error: ordering terminated.");
        Order order = new Order();
        order.setUserId(userId);
        order.setShipAddress(shipAddress);
        order.setBillAddress(billAddress);
        order.setStatus(OrderStat.ordering);
        orderMapper.addOrder(order);
        order = orderMapper.getOrderByStatus(userId,OrderStat.ordering);

        for (OrderItem it : cart) {
            it.setOrderId(order.getOrderId());
        }
        orderMapper.addOrderItem(cart);

        order.setStatus(OrderStat.success);
        orderMapper.updateOrder(order);

        order.setItems(cart);
        return order;
    }

    public boolean haveOrderingOrder(Integer userId){
        if (userId == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "userId is required");
        return orderMapper.getOrderByStatus(userId,OrderStat.ordering)!=null;
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
