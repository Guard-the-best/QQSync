package cn.edu.csu.dyp.Service;

import cn.edu.csu.dyp.Persistence.GoodsMapper;
import cn.edu.csu.dyp.Dto.order.CartDto;
import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.goods.Product;
import cn.edu.csu.dyp.model.order.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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
        return goodsMapper.getProductsByCategory(categoryName);
    }
//
    public List<Item> getItemsByProduct(String productId) {
        return goodsMapper.getItemsByProductId(productId);
    }
//
    public Item getItemById(Integer itemId) {
        return goodsMapper.getItemByItemId(itemId);
    }

    public List<Product> searchProductByKey(String key) {
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
    public List<OrderItem> toOrderList(CartDto.CartItem[] cart) {
        if (cart == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "cart is required");

        List<OrderItem> list = new ArrayList<>();
        for (CartDto.CartItem cartItem : cart) {
            Item item = getItemById(cartItem.getItemId());
            OrderItem temp = new OrderItem();
            temp.setItemId(cartItem.getItemId());
            temp.setListPrice(item.getListPrice());
            temp.setAttributes(item.getAttributes());
            temp.setNumber(cartItem.getQuantity());
            list.add(temp);
        }
        return list;
    }
}
