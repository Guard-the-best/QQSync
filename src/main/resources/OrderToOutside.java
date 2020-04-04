import java.math.BigDecimal;
import java.util.Date;

public class OrderToOutside {
    String orderId;
    String name;
    Integer quantity;
    Date date;
    BigDecimal price;
    String address;


    public OrderToOutside(String orderId, String name, Integer quantity, Date date, BigDecimal price, String address) {
        this.orderId = orderId;
        this.name = name;
        this.quantity = quantity;
        this.date = date;
        this.price = price;
        this.address = address;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

