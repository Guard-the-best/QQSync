package cn.edu.csu.dyp.model.order;

import cn.edu.csu.dyp.model.util.OrderStat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    private String orderId;
    private String userId;
    private Date orderDate;
    private String shipAddress;
    private String billAddress;
    private OrderStat status;
    private List<OrderItem> items;
}
