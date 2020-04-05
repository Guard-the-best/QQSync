package cn.edu.csu.dyp.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CartServiceTest {
    @Autowired
    private CartService cartService;

    @Test
    void test(){
        cartService.modify(1,-1,-1);
    }
}
