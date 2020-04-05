package cn.edu.csu.dyp.model.cart;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItem {
    private Integer itemId;
    private String productName;
    private BigDecimal listPrice;
    private String attributes;
    private Integer quantity;
}
