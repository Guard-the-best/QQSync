package cn.edu.csu.dyp.model.goods;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Integer categoryId;
    private Integer productId;
    private String productName;
}

