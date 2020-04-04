package cn.edu.csu.dyp.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderItem {
    private int itemId;
    private BigDecimal listPrice;
    private String attributes;
    private Integer number;
}
