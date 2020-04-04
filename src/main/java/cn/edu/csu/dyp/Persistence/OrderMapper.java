package cn.edu.csu.dyp.Persistence;

//import cn.edu.csu.dyp.archived.model.user.LineItem;
import cn.edu.csu.dyp.model.order.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    void addOrder(Order order);
    List<Order> getOrder(String userId);
    void deleteOrder(Order order);
    void updateOrder(Order order);
}
