package cn.edu.csu.dyp.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem  {
    private int lineId;
    private int userId;
    private int itemId;
    private int quantity;
}
