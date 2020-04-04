package cn.edu.csu.dyp.model.order;

import cn.edu.csu.dyp.model.util.OrderStat;
import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private String userId;
    private Date orderDate;
    private String shipAddress;
    private String billAddress;
    private OrderStat status;
    private List<OrderItem> items;
 }
