package cn.edu.csu.dyp.Persistence;

import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.goods.Product;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@MapperScan("cn.edu.csu.dyp.Persistence")
public class GoodsDaoTest {

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    void searchProductByKeyTest(){
        String key = "";
        List<Product> products = goodsMapper.searchProductByKey(key);
        System.out.println(products.size());
    }

    @Test
    void getProductsByCategoryTest(){
        String key = "Dog";
        List<Product> products = goodsMapper.getProductsByCategory(key);
        System.out.println(products.isEmpty());
    }

    @Test
    void getProductId(){
        System.out.println(goodsMapper.getProductId("Labrador Retriever"));
    }

    @Test
    void getItemsByProductIdTest(){
        String name = "dog";
        List<Item> items = goodsMapper.getItemsByProductId(1002);
        System.out.println(items.isEmpty());
    }

    @Test
    void getItemByItemIdTest(){
        int key =10001;
        Item item = goodsMapper.getItemByItemId(key);
        System.out.println(item.getAttributes());
    }
}
