package cn.edu.csu.dyp.Service;

import cn.edu.csu.dyp.Persistence.GoodsMapper;
import cn.edu.csu.dyp.Dto.order.CartDto;
import cn.edu.csu.dyp.model.goods.Category;
import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.goods.Product;
import cn.edu.csu.dyp.model.order.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

@Service
public class GoodsService {
    GoodsMapper goodsMapper;
    @Autowired
    public GoodsService(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    //    private static Logger logger=Logger.getLogger(DataBaseDao.class);

    public List<String> getCategories() {
        return goodsMapper.getAllCategory();
    }

    public List<Product> getProductsByCategory(String categoryName) {
        return goodsMapper.getProductsByCategory(categoryName);
    }

    public List<Product> searchProductByKey(String key) {
        return goodsMapper.searchProductByKey(key);
    }
//
    public List<Item> getItemsByProduct(String productName) {
        return goodsMapper.getItemsByProductId(goodsMapper.getProductId(productName));
    }
//
    public Item getItemById(Integer itemId) {
        return goodsMapper.getItemByItemId(itemId);
    }

    public void updateItem(Item item){
        goodsMapper.updateItem(item);
    }

    public void addItem(Item item){
        goodsMapper.addItem(item);
    }

    public void clearItem(Integer itemId){
        goodsMapper.updateItem(new Item(itemId,null,null,0,null));
    }

    public void modifyProduct(Product product){
        if(product.getProductId()==null)
            goodsMapper.addProduct(product);
        else
            goodsMapper.updateProduct(product);
    }

    public void clearProduct(String productName){
        List<Item> items=goodsMapper.getItemsByProductId(goodsMapper.getProductId(productName));
        for(Item item:items){
            clearItem(item.getItemId());
        }
    }

    public void modifyCategory(Category category){
        if(category.getCategoryId()==null)
            goodsMapper.addCategory(category);
        else
            goodsMapper.updateCategory(category);
    }


    public void clearCategory(String categoryName){
        List<Product> list=getProductsByCategory(categoryName);
        for(Product product:list){
            clearProduct(product.getProductName());
        }
    }

    public void clearAll(){
        List<String> list=getCategories();
        for(String name:list){
            clearCategory(name);
        }
    }

    public void modifyItemInventory(Integer itemId,Integer delta){
        goodsMapper.updateItem(new Item(itemId,null,null,max(goodsMapper.getItemByItemId(itemId).getInventory()+delta,0),null));
    }

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
