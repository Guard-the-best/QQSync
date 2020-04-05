package cn.edu.csu.dyp.model.goods;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Item {
    private Integer itemId;
    private Integer productId;
    private BigDecimal listPrice;
    private Integer inventory;
    private String attributes;
}
