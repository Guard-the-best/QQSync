package cn.edu.csu.dyp.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private Integer orderId;
    private Integer itemId;
    private BigDecimal listPrice;
    private String attributes;
    private Integer number;
}
