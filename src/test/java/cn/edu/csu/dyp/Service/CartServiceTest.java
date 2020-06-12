package cn.edu.csu.dyp.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class CartServiceTest {
    @Autowired
    private CartService cartService;

    @Test
    void test(){
        cartService.modify(1,-1,-1);
    }
}
