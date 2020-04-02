package cn.edu.csu.dyp.Persistence;

import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.goods.Product;
import cn.edu.csu.dyp.model.user.Order;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("cn.edu.csu.dyp.Persistence")
public class GoodsDaoTest {

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    void searchProductByKeyTest(){
        String key = "e";
        List<Product> products = goodsMapper.searchProductByKey(key);
        System.out.println(products.isEmpty());
    }

    @Test
    void getProductsByCategoryTest(){
        String key = "Dog";
        List<Product> products = goodsMapper.getProductsByCategory(key);
        System.out.println(products.isEmpty());
    }

    @Test
    void getItemsByProductIdTest(){
        String key = "1001";
        List<Item> items = goodsMapper.getItemsByProductId(key);
        System.out.println(items.isEmpty());
    }

    @Test
    void getItemByItemIdTest(){
        int key =10001;
        List<Item> items = goodsMapper.getItemByItemId(key);
        System.out.println(items.isEmpty());
    }
}
