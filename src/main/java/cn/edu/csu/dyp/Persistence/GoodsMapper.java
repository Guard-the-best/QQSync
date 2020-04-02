package cn.edu.csu.dyp.Persistence;

import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.goods.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    List<Product> searchProductByKey(String key);
    List<Product> getProductsByCategory(String categoryName);
    List<Item> getItemsByProductId(String productId);
    List<Item> getItemByItemId(int itemId);
}
