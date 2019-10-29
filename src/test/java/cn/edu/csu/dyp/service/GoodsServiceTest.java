package cn.edu.csu.dyp.service;


import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.goods.Product;
import org.junit.Test;

import java.util.List;

public class GoodsServiceTest {
    @Test
    public void getCategories() {
    }

    @Test
    public void getProductsByCategory() {
        List<Product> list= new GoodsService().getProductsByCategory("Dog");
        list.size();
    }

    @Test
    public void getItemsByProduct() {
        List<Product> temp= new GoodsService().getProductsByCategory("Dog");
        List<Item> list = new GoodsService().getItemsByProduct(temp.get(0).getProductId());
        list.size();
    }

    @Test
    public void getItemById() {
    }

    @Test
    public void getProductById() {
    }

    @Test
    public void getCategoryById() {
    }

    @Test
    public void searchProductByKey() {
        List<Product> list= new GoodsService().searchProductByKey("o");
        list.size();
    }

}
