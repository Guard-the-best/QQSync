package cn.edu.csu.dyp.Persistence;

//import cn.edu.csu.dyp.archived.model.user.LineItem;
import cn.edu.csu.dyp.model.order.Order;
import cn.edu.csu.dyp.model.order.OrderItem;
import cn.edu.csu.dyp.model.util.OrderStat;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    void addOrder(Order order);
    List<Order> getOrder(int userId);
    Order getOrderByStatus(int userId, OrderStat stat);
    void deleteOrder(Order order);
    void updateOrder(Order order);

    // 下为OrderItem的代码
    void addOrderItem(List<OrderItem> orderItems);
    List<OrderItem> getOrderItems(int orderId);
}
