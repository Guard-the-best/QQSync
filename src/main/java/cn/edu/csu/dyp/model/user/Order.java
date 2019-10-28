package cn.edu.csu.dyp.model.user;

import cn.edu.csu.dyp.service.util.OrderStat;

import java.util.Date;
import java.util.List;

public class Order {
    private String userId;
    private Date orderDate;
    private String shipAddress;
    private String billAddress;
    private OrderStat status;
    private List<LineItem> lineItemIds;

    public Order(String userId, Date orderDate, String shipAddress, String billAddress, OrderStat status, List<LineItem> lineItemIds) {
        this.userId = userId;
        this.orderDate = orderDate;
        this.shipAddress = shipAddress;
        this.billAddress = billAddress;
        this.status = status;
        this.lineItemIds = lineItemIds;
    }

    public List<LineItem> getLineItemIds() {
        return lineItemIds;
    }

    public void setLineItemIds(List<LineItem> lineItemIds) {
        this.lineItemIds = lineItemIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(String billAddress) {
        this.billAddress = billAddress;
    }

    public OrderStat getStatus() {
        return status;
    }

    public void setStatus(OrderStat status) {
        this.status = status;
    }
}
