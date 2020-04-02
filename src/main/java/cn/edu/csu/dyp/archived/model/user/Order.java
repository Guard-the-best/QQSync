package cn.edu.csu.dyp.archived.model.user;

import cn.edu.csu.dyp.Service.util.OrderStat;

import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private String userId;
    private Date orderDate;
    private String shipAddress;
    private String billAddress;
    private OrderStat status;
    private List<LineItem> lineItemList;

    public Order(String orderId, String userId, Date orderDate, String shipAddress, String billAddress, OrderStat status, List<LineItem> lineItemList) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.shipAddress = shipAddress;
        this.billAddress = billAddress;
        this.status = status;
        this.lineItemList = lineItemList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<LineItem> getLineItemList() {
        return lineItemList;
    }

    public void setLineItemList(List<LineItem> lineItemList) {
        this.lineItemList = lineItemList;
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
