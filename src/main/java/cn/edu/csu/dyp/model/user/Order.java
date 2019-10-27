package cn.edu.csu.dyp.model.user;

import cn.edu.csu.dyp.service.util.OrderStat;

import java.util.Date;

public class Order {
    private String userId;
    private Date orderDate;
    private Address shipAddress;
    private Address billAddress;
    private OrderStat status;
    private LineItem[]  lineItemIds;

    public Order(String userId, Date orderDate, Address shipAddress, Address billAddress, OrderStat status, LineItem[] lineItemIds) {
        this.userId = userId;
        this.orderDate = orderDate;
        this.shipAddress = shipAddress;
        this.billAddress = billAddress;
        this.status = status;
        this.lineItemIds = lineItemIds;
    }

    public LineItem[] getLineItemIds() {
        return lineItemIds;
    }

    public void setLineItemIds(LineItem[] lineItemIds) {
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

    public Address getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(Address shipAddress) {
        this.shipAddress = shipAddress;
    }

    public Address getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(Address billAddress) {
        this.billAddress = billAddress;
    }

    public OrderStat getStatus() {
        return status;
    }

    public void setStatus(OrderStat status) {
        this.status = status;
    }
}
