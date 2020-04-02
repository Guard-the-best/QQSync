package cn.edu.csu.dyp.archived.service;


import cn.edu.csu.dyp.Service.GoodsService;
import cn.edu.csu.dyp.archived.model.goods.Category;
import cn.edu.csu.dyp.archived.model.goods.Item;
import cn.edu.csu.dyp.archived.model.goods.Product;

import java.util.List;

public class GoodsServiceTest {
//    @Test
    public void getProductsByCategory() {
        List<Product> list= new GoodsService().getProductsByCategory("Dog");
        list.size();
    }

//    @Test
    public void getItemsByProduct() {
        List<Product> temp= new GoodsService().getProductsByCategory("Dog");
        List<Item> list = new GoodsService().getItemsByProduct(temp.get(0).getProductId());
        list.size();
    }

//    @Test
    public void getItemById() {
        Item item = new GoodsService().getItemById("10001");
        item.getInventory();
    }

//    @Test
    public void getProductById() {
        Item item = new GoodsService().getItemById("10001");
        Product product = new GoodsService().getProductById(item.getProductId());
        product.getProductId();
    }

//    @Test
    public void getCategoryById() {
        Item item = new GoodsService().getItemById("10001");
        Product product = new GoodsService().getProductById(item.getProductId());
        Category category = new GoodsService().getCategoryById(product.getCategoryId());
        category.getCategoryName();
    }

//    @Test
    public void searchProductByKey() {
        List<Product> list= new GoodsService().searchProductByKey("o");
        list.size();
    }

}
