package cn.edu.csu.dyp.Service;

import cn.edu.csu.dyp.Persistence.GoodsMapper;
import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.goods.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GoodsService {
    GoodsMapper goodsMapper;
    @Autowired
    public GoodsService(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    //    private static Logger logger=Logger.getLogger(DataBaseDao.class);
    public List<Product> getProductsByCategory(String categoryName) {
        if(categoryName == null || categoryName.equals("")) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "category name is required");
        return goodsMapper.getProductsByCategory(categoryName);
    }
//
    public List<Item> getItemsByProduct(String productId) {
        if(productId == null || productId.equals("")) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "product name is required");
        return goodsMapper.getItemsByProductId(productId);
    }
//
    public Item getItemById(Integer itemId) {
        return goodsMapper.getItemByItemId(itemId);
    }

    public List<Product> searchProductByKey(String key) {
        if (key == null) key = "";
        return goodsMapper.searchProductByKey(key);
    }
//
//    @Deprecated
//    public Product getProductById(String productId) {
//        return null;
//    }
//
//    @Deprecated
//    public Category getCategoryById(String categoryId) {
//        return null;
//    }
//

}
