package cn.edu.csu.dyp.Service;

import cn.edu.csu.dyp.model.goods.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class GoodServiceTest {
    @Autowired
    private GoodsService goodsService;

    @Test
    void updateItem(){
        Item item =new Item(10001,1002,null,10,null);
        goodsService.updateItem(item);
        System.out.println(goodsService.getItemById(10001));
    }

}
