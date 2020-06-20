package cn.edu.csu.dyp.model.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer categoryId;
    private Integer productId;
    private String productName;
}

