package cn.edu.csu.dyp;

import cn.edu.csu.dyp.Service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JpetstoreApplicationTests {

    @Autowired
    private CartService cartService;
    @Test
    void cartServiceTest(){
        cartService.addToCart("60","50",99);
    }

    @Test
    void contextLoads() {

    }
}
