package cn.edu.csu.dyp.Persistence;

import cn.edu.csu.dyp.archived.model.user.LineItem;
import cn.edu.csu.dyp.model.user.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    void addOrder(Order order);
    List<Order> getOrder(String userId);
    String getOrderId(String userId);
    void modifyItemStatus(String userId, String orderId, List<LineItem> lineItemList);
}
