package cn.edu.csu.dyp.Persistence;
import cn.edu.csu.dyp.model.goods.Item;
import cn.edu.csu.dyp.model.goods.Product;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("cn.edu.csu.dyp.Persistence")
public class CartDaoTest {

    @Autowired
    private CartMapper cartMapper;

    @Test
    void addItemTest(){
        int parentId = 10086;
        int itemId = 12306;
        cartMapper.addItem(parentId,itemId);
    }
}
