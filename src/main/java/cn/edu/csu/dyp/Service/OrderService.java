package cn.edu.csu.dyp.Service;

import cn.edu.csu.dyp.Persistence.OrderMapper;
import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.order.Order;
import cn.edu.csu.dyp.model.order.OrderItem;
import cn.edu.csu.dyp.model.util.OrderStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderService {
//    private static Logger logger=Logger.getLogger(DataBaseDao.class);
//    /*
//     * Date sql自动填写,lineItem only use itemId and quantity
//     * */
    private OrderMapper orderMapper;
    private GoodsService goodsService;

    @Autowired
    public OrderService(OrderMapper orderMapper,GoodsService goodsService) {
        this.orderMapper = orderMapper;
        this.goodsService = goodsService;
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
        for (OrderItem it : cart)
            if(it.getNumber()>goodsService.getItemById(it.getItemId()).getInventory())
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,it.getItemId()+"超出库存");
        for (OrderItem it : cart) {
            goodsService.modifyItemInventory(it.getItemId(),-it.getNumber());
        }
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
