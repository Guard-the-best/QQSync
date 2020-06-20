package cn.edu.csu.dyp.Persistence;

import cn.edu.csu.dyp.model.goods.Category;
import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.goods.Product;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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

    @Test
    void addItem(){
        goodsMapper.addItem(new Item(1,1,new BigDecimal(100),1,"test"));
        System.out.println(goodsMapper.getItemsByProductId(1));
    }

    @Test
    void addCategory(){
        goodsMapper.addCategory(new Category(null,"Pet"));
        System.out.println(goodsMapper.getAllCategory());
    }

    @Test
    void updateCategory(){
        goodsMapper.updateCategory(new Category(101,"Pet"));
        System.out.println(goodsMapper.getAllCategory());
    }

    @Test
    void addProduct(){
        goodsMapper.addProduct(new Product(101,null,"test Dog"));
        System.out.println(goodsMapper.getProductsByCategory("Dog"));
    }

    @Test
    void updateProduct(){
        goodsMapper.updateProduct(new Product(102,1001,"test Pet2"));
        System.out.println(goodsMapper.getProductsByCategory("Dog"));
    }
}
