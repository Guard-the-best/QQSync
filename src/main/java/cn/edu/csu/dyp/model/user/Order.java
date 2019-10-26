package cn.edu.csu.dyp.model.user;

import cn.edu.csu.dyp.model.user.Address;

import java.util.Date;

public class Order {
    private String orderId;
    private String name;
    private Address shipAddress;
    private Address billAddress;
    private Date orderDate;
    private int status;

    public Order(String name, Address shipAddress, Address billAddress, Date orderDate, int status) {
        this.orderId = null;
        this.name = name;
        this.shipAddress = shipAddress;
        this.billAddress = billAddress;
        this.orderDate = orderDate;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
